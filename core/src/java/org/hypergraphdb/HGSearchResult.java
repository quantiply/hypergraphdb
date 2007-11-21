/*
 * This file is part of the HyperGraphDB source distribution. This is copyrighted
 * software. For permitted uses, licensing options and redistribution, please see 
 * the LicensingInformation file at the root level of the distribution. 
 *
 * Copyright (c) 2005-2006
 *  Kobrix Software, Inc.  All rights reserved.
 */
package org.hypergraphdb;

/**
 * <p>
 * Represents the result set of a HyperGraph query. 
 * </p>
 * 
 * @author Borislav Iordanov
 */
public interface HGSearchResult<T> extends TwoWayIterator<T>
{
    /**
     * <p>Returns the current element in the result set. If there is no current element,
     * <code>java.util.NoSuchElementException</code> is thrown. There
     * is no current element in one of two cases: either the
     * result set is empty or the <code>next</code> method was never 
     * invoked.
     * </p>
     * 
     * @return The current element in a <code>HGSearchResult</code>.
     * @throw NoSuchElementException if there is no current element.
     */
    T current();
    
    /**
     * <p>Free all system resources held up by the result set and invalidate
     * it for further use.</p> 
     */
    void close();    
    
    /**
     * <p>Return <code>true</code> if the elements in this search result are in ordered
     * and <code>false</code> otherwise. It is assumed that when elements are ordered, 
     * they are instances of <code>java.lang.Comparable</code>
     */
    boolean isOrdered();
    
    /**
     * <p>
     * This object represents an empty <code>HGSearchResult</code>. Calls to
     * <code>hasPrev</code> or <code>hasNext</code> will always return <code>false</code>.
     * Calls to <code>current</code>, <code>next</code> or <code>prev</code> will always
     * throw a <code>NoSuchElementException</code>.  
     * </p>
     */
    public static final HGSearchResult EMPTY = new EmptySearchResult();
}