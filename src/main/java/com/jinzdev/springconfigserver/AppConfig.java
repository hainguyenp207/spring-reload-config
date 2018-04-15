package com.jinzdev.springconfigserver;

public class AppConfig {

    private boolean isProduction;
    private DatabaseConfig databaseConfig;

    public boolean isProduction() {
        return isProduction;
    }

    public void setProduction(boolean production) {
        isProduction = production;
    }

    public DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public void setDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }
}
