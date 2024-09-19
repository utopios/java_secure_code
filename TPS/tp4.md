### TP 4 : **Chiffrement avancé et gestion sécurisée des clés dans un environnement distribué**

#### Contexte :
Ce **TP 4** fait suite au TP 3 où vous avez mis en place un système de paiement sécurisé en validant les données et en intégrant des politiques de sécurité pour les ressources front-end. Dans cette étape, vous allez vous concentrer sur l'implémentation d'un chiffrement avancé et la gestion sécurisée des clés dans un environnement distribué, en tenant compte des bonnes pratiques suivantes :
- Ne pas utiliser de codage à des fins de protection.
- Utiliser des algorithmes de chiffrement revus et sécurisés.
- Utiliser les clés de chiffrement les plus longues possibles.


#### Exigences :

1. **Mise en œuvre d’un chiffrement sécurisé avec AES et RSA** :
   - Implémenter un chiffrement hybride qui combine **AES** pour chiffrer les données sensibles et **RSA** pour chiffrer la clé AES. Cela permet d’avoir un chiffrement rapide avec AES et une distribution sécurisée des clés avec RSA.
   - Utilisez **AES-256** pour garantir que la clé est suffisamment longue et résistante à des attaques brutales.
   - Vous devez vous assurer que le chiffrement des clés AES avec RSA utilise une clé publique d'au moins **2048 bits**.

   **Objectifs** :
   - Chiffrer les données des transactions (numéros de carte, montants) avec AES.
   - Utiliser RSA pour sécuriser la clé AES utilisée pour chiffrer les transactions, garantissant ainsi que seule la partie autorisée peut la déchiffrer.


2. **Audit des actions sur les clés de chiffrement** :
   - Implémentez un **système de logging** pour auditer toutes les actions effectuées sur les clés de chiffrement et paiement. Cela est essentiel pour répondre aux normes de conformité et de sécurité (comme PCI-DSS pour les données de carte de crédit).
   - Les logs doivent être stockés dans un environnement sécurisé, et seuls les administrateurs autorisés doivent pouvoir y accéder.

   **Objectifs** :
   - Implémenter une solution d’audit qui capture toutes les actions liées aux clés.
   - Configurer les accès aux logs pour garantir leur intégrité et confidentialité.
