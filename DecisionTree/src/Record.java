import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a row in the table with all the data.
 * @param <T> The type of the output variable (class/category) of this Record.
 */
public class Record<T> {

    /**
     * A Map with the features/attributes of this Record, keyed by their title.
     */
    private Map<String, Feature<?>> features;

    /**
     * The class/category of this Record. It may or may not be present. Non null
     * values indicate that the target is present, otherwise null values
     * indicate that it is not.
     */
    private T target;

    /**
     * Creates a Record, given its Feature's' and target value.
     * @param features The Feature's' of this Record.
     * @param target The target value of this Record. Can be null, to indicate
     * that this Record has no target value. It is useful for creating Record's'
     * that need to be classified.
     * @throws IllegalArgumentException If features.isEmpty() == true.
     */
    public Record(@NotNull Collection<Feature<?>> features,
            @Nullable T target) {
        //Validates that features Collections contains at least 1 element
        if (features.isEmpty()) {
            throw new IllegalArgumentException("Argument Collection features " +
                    "must contain at least 1 element.");
        }//end if

        //Creates a Map with the features/attributes of this Record, keyed by
        //their title.
        Map<String, Feature<?>> featureMap = new HashMap<>(features.size());
        //Populates featureMap
        for (Feature<?> f : features) {
            //Puts Feature f in featureMap
            featureMap.put(f.getTitle(), f);
        }//end for

        this.features = featureMap;
        this.target = target;
    }

    /**
     * Gets an unmodifiable Map, with the Feature's' of this Record, keyed by
     * their title.
     * @return An unmodifiable Map, with the Feature's' of this Record, keyed by
     * their title.
     */
    public @NotNull Map<String, Feature<?>> getFeatures() {
        return Collections.unmodifiableMap(this.features);
    }

    /**
     * Gets the class/category of this Record. Non null values indicate that the
     * target is present, otherwise null values indicate that it is not.
     * @return The class/category of this Record or null if the target value is
     * not present.
     */
    public @Nullable T getTarget() {
        return this.target;
    }

}//end class Record