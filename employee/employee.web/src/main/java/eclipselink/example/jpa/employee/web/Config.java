/*******************************************************************************
 * Copyright (c) 2010-2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  dclarke - initial
 ******************************************************************************/
package eclipselink.example.jpa.employee.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * TODO
 * 
 * @author dclarke
 * @since EclipseLink 2.4.2
 */
@ManagedBean
@SessionScoped
public class Config {
    
    private boolean displaySql = false;

    public boolean isDisplaySql() {
        return displaySql;
    }

    public void setDisplaySql(boolean displaySql) {
        this.displaySql = displaySql;
    }
    
    public void toggleSqlDisplay() {
        this.displaySql = !this.displaySql;
    }
}
