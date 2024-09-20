package com.example.correction_tps.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    // Pointcut pour tous les contrôleurs REST
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPointcut() {}

    // Pointcut pour tous les services
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceLayerPointcut() {}

    // Gestion des exceptions pour les contrôleurs REST
    @AfterThrowing(pointcut = "restControllerPointcut()", throwing = "exception")
    public void handleRestControllerException(Throwable exception) {
        logger.error("Exception dans un contrôleur REST : ", exception);
        // Vous pouvez également envoyer une réponse HTTP personnalisée ici
    }

    // Gestion des exceptions pour les services
    @AfterThrowing(pointcut = "serviceLayerPointcut()", throwing = "exception")
    public void handleServiceException(Throwable exception) {
        logger.error("Exception dans le service : ", exception);
        // Vous pouvez également implémenter un traitement des exceptions ici
    }

    // Gestion globale des exceptions avec une réponse cohérente pour les contrôleurs REST
    @Around("restControllerPointcut()")
    public Object handleControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed(); // Exécute la méthode cible
        } catch (Exception ex) {
            logger.error("Erreur interceptée dans le contrôleur REST : ", ex);
            return new ResponseEntity<>("Une erreur s'est produite : " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
