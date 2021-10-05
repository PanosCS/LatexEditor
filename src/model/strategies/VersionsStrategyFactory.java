package model.strategies;

public class VersionsStrategyFactory {

    public VersionsStrategy createStrategy(String type){
        return type.equals("stable") ? new StableVersionsStrategy() : new VolatileVersionsStrategy();
    }
}
