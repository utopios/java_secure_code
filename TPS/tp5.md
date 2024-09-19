### TP 5 : **Gestion Sécurisée des Variables Partagées et Prévention des Accès Concurrents**



#### Objectifs :
- Comprendre les risques de sécurité liés aux variables partagées et aux accès concurrents.
- Implémenter des mécanismes de synchronisation pour protéger les variables partagées.
- Utiliser les classes de synchronisation de Java telles que `ReentrantLock` et les collections sécurisées de `java.util.concurrent`.
- Mettre en place un audit des opérations pour détecter les accès non autorisés ou les conflits potentiels.

#### Exigences :

1. **Mise en Place de Verrous pour Protéger les Variables Partagées :**
   - Créer une classe représentant un compte bancaire (`BankAccount`) avec une méthode pour déposer (`deposit`) et retirer (`withdraw`) de l'argent.
   - Utiliser `ReentrantLock` pour synchroniser l'accès au solde du compte et éviter les conditions de course.
   - Implémenter un scénario où plusieurs threads tentent de déposer et retirer de l'argent simultanément.

2. **Utilisation de Collections Concurremment Sécurisées :**
   - Utiliser `ConcurrentHashMap` pour implémenter une base de données simplifiée de comptes bancaires, où chaque compte est identifié par un numéro de compte.
   - Permettre des opérations simultanées de dépôt et de retrait sur différents comptes bancaires en utilisant plusieurs threads.
   - Assurer que les opérations se déroulent correctement même en cas de forte concurrence.

3. **Audit et Journalisation des Opérations :**
   - Implémenter un système de journalisation qui enregistre toutes les actions effectuées sur les comptes (dépôt, retrait).
   - S'assurer que les journaux sont stockés de manière sécurisée et accessibles uniquement aux utilisateurs autorisés.
   - Détecter et signaler toute tentative d'accès concurrent non autorisée.

