package com.example.correction_tps.aspect;


import com.example.correction_tps.exception.RateLimitExceededException;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimitAspect {

    private final ConcurrentHashMap<String, Bucket> normalBuckets = new ConcurrentHashMap<>();

    // Buckets pour les opérations critiques
    private final ConcurrentHashMap<String, Bucket> criticalBuckets = new ConcurrentHashMap<>();

    // Limite pour les opérations normales : 10 requêtes toutes les 10 minutes
    private static final Bandwidth NORMAL_LIMIT = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMinutes(10)));

    // Limite pour les opérations critiques : 5 requêtes par heure
    private static final Bandwidth CRITICAL_LIMIT = Bandwidth.classic(5, Refill.greedy(5, Duration.ofHours(1)));

    // Créer un bucket pour les opérations normales
    private Bucket createNormalBucket(String userId) {
        return Bucket4j.builder().addLimit(NORMAL_LIMIT).build();
    }

    // Créer un bucket pour les opérations critiques
    private Bucket createCriticalBucket(String userId) {
        return Bucket4j.builder().addLimit(CRITICAL_LIMIT).build();
    }

    private String getCurrentUserId() {
        // Implémentation pour récupérer l'ID utilisateur, par exemple à partir du contexte de sécurité
        return "defaultUserId"; // Exemple d'ID utilisateur par défaut
    }

    //Création d'un pointcut complexe
    @Pointcut("@annotation(com.example.correction_tps.annotation.Critical)")
    public void criticalTransaction() {

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(* com.example.correction_tps.controller..*(..)) && !@annotation(com.example.correction_tps.annotation.Critical)")
    public void normalTransaction() {

    }

    @Before("normalTransaction()")
    public void checkNormalTransactionLimit() throws RateLimitExceededException {
        String userId = getCurrentUserId(); // Récupérer l'ID de l'utilisateur actuel
        Bucket bucket = normalBuckets.computeIfAbsent(userId, this::createNormalBucket);
        if (!bucket.tryConsume(1)) {
            throw new RateLimitExceededException("Limite de requêtes normales dépassée");
        }
    }

    //@Before("@annotation(com.example.correction_tps.annotation.Critical)")
    @Before("criticalTransaction()")
    public void checkCriticalTransactionLimit() throws RateLimitExceededException {
        String userId = getCurrentUserId(); // Récupérer l'ID de l'utilisateur actuel
        Bucket bucket = criticalBuckets.computeIfAbsent(userId, this::createCriticalBucket);
        if (!bucket.tryConsume(1)) {
            throw new RateLimitExceededException("Limite de requêtes critiques dépassée");
        }
    }
}
