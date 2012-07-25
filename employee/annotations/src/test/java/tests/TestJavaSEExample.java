/*******************************************************************************
 * Copyright (c) 2010-2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  dclarke - Employee Demo 2.4
 ******************************************************************************/
package tests;

import javax.persistence.EntityManager;

import org.junit.Test;

import example.JavaSEExample;

public class TestJavaSEExample extends AbstractBaseTest{

  private JavaSEExample example = new JavaSEExample();
  
  @Test
  public void queryAllEmployees() {
      EntityManager em = getEmf().createEntityManager();
      
      example.queryAllEmployees(em);
      
      em.close();
  }

}
