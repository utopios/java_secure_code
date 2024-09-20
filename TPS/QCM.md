Voici le QCM de 30 questions sans les réponses :

### QCM : Secure Coding en Java

#### 1. Objectifs de la Sécurité
1. **Quels sont les trois principaux objectifs de la sécurité informatique ?**
   - A) Disponibilité, rapidité, confidentialité
   - B) Intégrité, disponibilité, confidentialité
   - C) Sécurité, authenticité, rapidité
   - D) Intégrité, rapidité, sécurité

2. **Pourquoi est-il important de réduire les risques de sécurité dans les applications ?**
   - A) Pour augmenter la complexité du code
   - B) Pour rendre le développement plus rapide
   - C) Pour protéger les données sensibles des utilisateurs
   - D) Pour réduire les performances

3. **Quel est l'un des moyens efficaces de répondre aux nécessités de sécurité ?**
   - A) Augmenter le nombre de développeurs
   - B) Utiliser des outils de test automatisés
   - C) Ignorer les petites vulnérabilités
   - D) Diminuer les sessions utilisateur

#### 2. Chiffrement et Authentification
4. **Quel type de chiffrement utilise la même clé pour chiffrer et déchiffrer des données ?**
   - A) Chiffrement asymétrique
   - B) Chiffrement symétrique
   - C) Chiffrement homomorphique
   - D) Chiffrement quantique

5. **Quel est le principal avantage du chiffrement à clé publique ?**
   - A) Il est plus rapide que le chiffrement à clé symétrique
   - B) Il permet d'échanger des clés en toute sécurité sur un canal non sécurisé
   - C) Il nécessite moins de calculs
   - D) Il ne peut pas être déchiffré

6. **Quelle est la fonction principale d'une signature numérique ?**
   - A) Crypter le message pour le rendre illisible
   - B) Assurer l'intégrité et l'authenticité d'un message
   - C) Augmenter la taille du message
   - D) Masquer le contenu du message

#### 3. PCI-DSS et Gouvernance de la Sécurité
7. **Que signifie PCI-DSS ?**
   - A) Payment Card Industry Data Security Standard
   - B) Personal Card Information Data Security Standard
   - C) Payment Customer Industry Digital Security Standard
   - D) Payment Card Integration Digital Security Standard

8. **Quel est l'un des principaux objectifs de la norme PCI-DSS ?**
   - A) Protéger les données des utilisateurs contre les attaques DDoS
   - B) Assurer la sécurité des données des cartes de paiement
   - C) Améliorer les performances des transactions bancaires
   - D) Réduire les frais de transaction

9. **À quel moment du cycle de vie du logiciel la sécurité devrait-elle être prise en compte ?**
   - A) Lors de la phase de déploiement
   - B) Lors de la phase de tests
   - C) Dès la phase de conception
   - D) Après la livraison

#### 4. Codage Sécurisé
10. **Quel principe de codage permet de minimiser l'impact des attaques potentielles ?**
    - A) La complexité du code
    - B) La redondance du code
    - C) La défense en profondeur
    - D) L'obfuscation du code

11. **Quelle est une bonne pratique pour implémenter une stratégie de mot de passe ?**
    - A) Utiliser des mots de passe courts et simples
    - B) Imposer un renouvellement quotidien du mot de passe
    - C) Utiliser un mélange de lettres, de chiffres et de caractères spéciaux
    - D) Interdire les mots de passe contenant des chiffres

12. **Quelle technique est recommandée pour la gestion des sessions ?**
    - A) Garder les sessions ouvertes indéfiniment
    - B) Invalider la session après une période d'inactivité
    - C) Partager les ID de session dans les URLs
    - D) Ne pas utiliser de sessions

13. **Quel est un principe fondamental de contrôle d'accès ?**
    - A) Tout autoriser par défaut
    - B) Refuser tout accès par défaut
    - C) Autoriser l'accès après un certain temps
    - D) Contrôler uniquement les utilisateurs invités

#### 5. Validation et Encodage des Données
14. **Pourquoi la validation des entrées utilisateur est-elle cruciale ?**
    - A) Pour rendre le code plus lisible
    - B) Pour améliorer les performances de l'application
    - C) Pour prévenir les injections et autres attaques
    - D) Pour compliquer la maintenance

15. **Quelle est une bonne pratique pour valider les données d'entrée ?**
    - A) Valider uniquement les données côté client
    - B) Valider les données côté serveur
    - C) Faire confiance aux données utilisateur
    - D) Accepter toutes les entrées sans vérification

16. **Quel est le rôle principal de l'encodage des données de sortie ?**
    - A) Réduire la taille des données
    - B) Assurer que les données ne contiennent pas de caractères dangereux
    - C) Convertir les données en binaire
    - D) Augmenter la complexité du code

#### 6. Gestion des Erreurs et Journalisation
17. **Quelle est une bonne pratique pour la gestion des erreurs ?**
    - A) Utiliser des messages d'erreur détaillés pour les utilisateurs
    - B) Masquer les détails des erreurs aux utilisateurs
    - C) Ignorer les exceptions
    - D) Arrêter l'application dès qu'une erreur survient

18. **Pourquoi est-il important de journaliser les exceptions de sécurité ?**
    - A) Pour améliorer la vitesse d'exécution
    - B) Pour identifier et corriger les vulnérabilités
    - C) Pour ajouter des informations inutiles aux journaux
    - D) Pour compliquer l'analyse des incidents

19. **Quelle information ne doit pas être incluse dans les journaux de logs ?**
    - A) Les adresses IP des utilisateurs
    - B) Les mots de passe en clair
    - C) L'heure de la requête
    - D) Le chemin d'accès aux fichiers

#### 7. Sécurisation des Communications
20. **Quelle est la méthode recommandée pour sécuriser les communications entre le client et le serveur ?**
    - A) Utiliser le protocole HTTP
    - B) Utiliser le protocole FTP
    - C) Utiliser le protocole HTTPS
    - D) Utiliser le protocole Telnet

21. **Pourquoi est-il important d'utiliser le chiffrement pour les données en transit ?**
    - A) Pour augmenter la vitesse de transmission
    - B) Pour protéger les données contre l'interception et la modification
    - C) Pour économiser de la bande passante
    - D) Pour réduire la taille des paquets

22. **Quel est le rôle des certificats SSL/TLS ?**
    - A) Crypter le disque dur
    - B) Authentifier le serveur et crypter les communications
    - C) Ajouter des mots de passe aux fichiers
    - D) Améliorer les performances du serveur

#### 8. Protection des Données Sensibles
23. **Quelle méthode est la plus sûre pour stocker des mots de passe ?**
    - A) En clair dans la base de données
    - B) Hachés avec un sel unique
    - C) Encodés en Base64
    - D) Stockés dans des cookies

24. **Quelle est une bonne pratique pour protéger les données sensibles ?**
    - A) Les stocker en texte clair
    - B) Utiliser des algorithmes de chiffrement robustes
    - C) Ne pas utiliser de chiffrement
    - D) Partager les clés de chiffrement avec tous les utilisateurs

25. **Pourquoi est-il important d'utiliser des jetons CSRF dans les applications web ?**
    - A) Pour empêcher les utilisateurs de se déconnecter
    - B) Pour protéger contre les attaques de type Cross-Site Request Forgery
    - C) Pour limiter le nombre de sessions utilisateur
    - D) Pour chiffrer les cookies de session

#### 9. Exposition des Données
26. **Pourquoi la validation des données d'entrée est-elle essentielle pour éviter les injections SQL ?**
    - A) Pour ralentir les performances du serveur
    - B) Pour empêcher l'utilisateur d'insérer des instructions SQL malveillantes
    - C) Pour permettre plus de flexibilité dans les requêtes
    - D) Pour simplifier l'écriture des requêtes SQL

27. **Qu'est-ce que l'injection XSS ?**
    - A) L'insertion de scripts malveillants dans une page web
    - B) Une méthode pour chiffrer les données
    - C) Une technique pour optimiser les performances
    - D) Un protocole de communication sécurisé

28. **Quelle est une bonne pratique pour prévenir les attaques de redirection ouverte ?**
    - A) Permettre les redirections vers n'importe quel domaine
    - B) Vérifier les URL de redirection avant de les utiliser
    - C) Désactiver les redirections
    - D) Ne pas utiliser de redirections

#### 10. Revue de Code et Méthodologie
29. **Pourquoi la revue de code est-elle importante dans le cycle de vie logiciel ?**
    - A) Pour augmenter le nombre de lignes de code
    - B) Pour identifier les vulnérabilités et les erreurs avant le déploiement
    - C) Pour rendre le code plus complexe
    - D) Pour permettre à plusieurs développeurs de modifier le même code

30. **Quel type de revue de code est le plus efficace pour identifier les failles de sécurité ?**
    - A) Revue de code manuelle
    - B) Revue de code automatisée uniquement
    - C) Revue de code basée sur le nombre de commits
    - D) Revue de code après la mise en production
