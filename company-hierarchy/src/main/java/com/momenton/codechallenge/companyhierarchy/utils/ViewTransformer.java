package com.momenton.codechallenge.companyhierarchy.utils;

/**
 * generic functional interface for the view transformation
 *
 * @param <T> - input model
 * @param <R> - output model
 */
@FunctionalInterface
public interface ViewTransformer<T, R> {

    	/**
    	 * transforms T to R
    	 * 
    	 * @param t - input model
    	 * @return output model R
    	 */
    	R transorm(T t);
}
