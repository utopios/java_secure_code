### TP 3 : **Sécurisation des données et des ressources dans un module de paiement en ligne**

#### Contexte :
Dans ce TP, vous allez développer un module de paiement sécurisé pour une plateforme e-commerce, avec une attention particulière à la sécurité des données sensibles (informations bancaires, données personnelles) et à la protection des ressources chargées depuis des sources externes. Ce TP permet de renforcer les aspects de sécurité abordés dans les TPs précédents, en se concentrant sur la validation des données côté serveur, et la mise en place de politiques de sécurité pour les ressources front-end.

#### Exigences :

1. **Validation des données sensibles côté serveur** :
   - L'objectif est de valider rigoureusement les informations soumises lors du processus de paiement, telles que les numéros de carte de crédit, les adresses et les montants.
   - La validation doit être effectuée exclusivement côté serveur, avec des contrôles stricts sur le format des numéros de carte, des dates d’expiration, des cryptogrammes (CVV) et d’autres données personnelles.
   - Il est essentiel de rejeter les données qui ne respectent pas les critères prédéfinis (par exemple, des formats invalides pour les emails ou les numéros de carte).



2. **Content Security Policy (CSP)** :
   - Vous devez mettre en place une politique **CSP** qui limite les sources autorisées pour le chargement des scripts, styles, images et autres ressources utilisées dans le front-end de la plateforme.
   - La **CSP** doit interdire tout script externe non autorisé et restreindre le chargement des ressources aux seuls domaines de confiance (par exemple, le CDN d'un fournisseur spécifique).
   - L’objectif est de protéger contre les attaques **Cross-Site Scripting (XSS)** en empêchant les scripts malveillants d'être exécutés dans le contexte de la page.

.



