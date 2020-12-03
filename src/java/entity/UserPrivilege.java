
package entity;

import java.io.Serializable;

/**
 * This enumeration is for users profiles. Includes the values USER and ADMIN. 
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
public enum UserPrivilege implements Serializable{
    /**
     * The user is a regular user.
     */
    USER,
    /**
     * The user is a privileged user.
     */
    ADMIN
}
