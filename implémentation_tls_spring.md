## Keytool pour générer des keystore
```bash
keytool -genkeypair -alias myserver -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650
```

## Dans le cadre ou on a nos propres clés

- clé privé (mykey.key)
- un fichier certificat (mycert.crt)

## Utilise openSSL pour combiner la clé privée et le certificat dans un fichier PKCS12
```
openssl pkcs12 -export -in mycert.crt -inkey mykey.key -out keystore.p12 -name myalias
```