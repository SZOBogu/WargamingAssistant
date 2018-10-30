public class ModelProfile40k extends ModelProfile {

    public Stats40k stats;
    public ModelProfile40k(Entity entity, Stats40k stats){
        super(entity);
        this.stats = stats;
    }

    public Stats40k getStats() {
        return stats;
    }
}
