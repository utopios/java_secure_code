## Validator Layer Pattern

## Secure Chain Of Responsibility

```java
public abstract class SecurityHandler {
    protected SecurityHandler next;

    public void setNext(SecurityHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

public class AuthenticationHandler extends SecurityHandler {
    @Override
    public void handleRequest(String request) {
        if (isAuthenticated(request)) {
            System.out.println("Authentification réussie.");
            if (next != null) next.handleRequest(request);
        } else {
            System.out.println("Échec de l'authentification.");
        }
    }

    private boolean isAuthenticated(String request) {
        // Logique d'authentification
    }
}

public class AuthorizationHandler extends SecurityHandler {
    @Override
    public void handleRequest(String request) {
        if (isAuthorized(request)) {
            System.out.println("Autorisation réussie.");
            if (next != null) next.handleRequest(request);
        } else {
            System.out.println("Échec de l'autorisation.");
        }
    }

    private boolean isAuthorized(String request) {
        // Logique d'autorisation
    }
}
```

### AOP

1. Aspect => sécurité, journalisation,...
2. Advice => la logique qui permet d'executer l'advice à un point sépcifique du programme.
    @Before
    @After

3. join point => point précis dans l'éxecution du programme
4. Pointcut => pour regrouper plusieurs join point
5. Weaving => processus d'application des aspects 