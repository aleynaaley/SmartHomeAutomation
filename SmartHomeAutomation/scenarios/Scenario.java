package scenarios;

/**
 * Tüm senaryo sınıfları için temel soyut sınıftır.
 */
public abstract class Scenario {

    /**
     * Senaryo çalıştırıldığında doğrudan executeScenario çağrılır.
     */
    public final void run() {
        executeScenario();
    }

    protected abstract void executeScenario();
}