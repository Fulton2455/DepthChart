/**
 * Custom Standard interface (based off of OSU Standard).
 *
 * @param <T>
 *            type with these methods
 */
public interface Standard<T> {
    /**
     * Resets this to an initial value. If the type T has a no-argument
     * constructor, then this satisfies the contract of the no-argument
     * constructor for T. If T does not have a no-argument constructor, then
     * this satisfies the contract of the constructor call that was used to
     * initialize #this.
     *
     * @clears this
     */
    void clear();

    /**
     * Sets this to the incoming value of source, and resets source to an
     * initial value; the declaration notwithstanding, the dynamic type of
     * source must be the same as the dynamic type of this. If the type T has a
     * no-argument constructor, then source satisfies the contract of the
     * no-argument constructor for T. If T does not have a no-argument
     * constructor, then source satisfies the contract of the constructor call
     * that was used to initialize #source.
     *
     * @param source
     *            object whose value is to be transferred
     * @replaces this
     * @clears source
     * @ensures this = #source
     */
    void transferFrom(T source);

    /**
     * Returns a new object with the same dynamic type as this, having an
     * initial value. If the type T has a no-argument constructor, then the
     * value of the new returned object satisfies the contract of the
     * no-argument constructor for T. If T does not have a no-argument
     * constructor, then the value of the new returned object satisfies the
     * contract of the constructor call that was used to initialize this .
     * 
     * @return new object "like" this with an initial value
     * @ensures is_initial(newInstance)
     */
    T newInstance();
}
