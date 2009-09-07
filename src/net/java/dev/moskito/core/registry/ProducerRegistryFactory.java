/*
 * $Id$
 * 
 * This file is part of the MoSKito software project
 * that is hosted at http://moskito.dev.java.net.
 * 
 * All MoSKito files are distributed under MIT License:
 * 
 * Copyright (c) 2006 The MoSKito Project Team. 
 * 
 * Permission is hereby granted, free of charge, 
 * to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), 
 * to deal in the Software without restriction, 
 * including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit 
 * persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice 
 * shall be included in all copies 
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY 
 * OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package net.java.dev.moskito.core.registry;

import net.java.dev.moskito.core.util.StartBuiltInProducers;


public class ProducerRegistryFactory {
	
	private static IProducerRegistry instance;
	
	static{
		instance = new ProducerRegistryImpl();
		StartBuiltInProducers.startbuiltin();
	}
	
	public static final IProducerRegistry getProducerRegistryInstance(){
		return instance;
	}
}

/* ------------------------------------------------------------------------- *
 * $Log: ProducerRegistryFactory.java,v $
 * Revision 1.4  2008/12/19 23:30:05  dvayanu
 * added support for java memory values from Runtime
 *
 * Revision 1.3  2008/07/29 22:06:20  dvayanu
 * removed unneeded synchronization
 *
 * Revision 1.2  2006/07/22 22:49:20  dvayanu
 * Issue number:  1
 *
 * Revision 1.1  2006/06/11 20:00:55  miros
 * #3: Refactored source files to comply the new project structure.
 *
 * Revision 1.1  2006/06/11 15:15:02  miros
 * #3: Initial commit with new project structure.
 *
 * Revision 1.1  2006/06/07 20:52:39  dvayanu
 * initial
 *
 * Revision 1.2  2006/05/28 23:25:08  lrosenberg
 * *** empty log message ***
 *
 * Revision 1.1  2006/05/26 15:42:30  lrosenberg
 * *** empty log message ***
 *
 */