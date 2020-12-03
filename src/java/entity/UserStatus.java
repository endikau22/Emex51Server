
package entity;

import java.io.Serializable;

/**
 * This enumeration is for users status. Includes the values ENABLED and DISABLED 
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
public enum UserStatus implements Serializable{
    /**
     * The user is enabled.
     */
    ENABLED,
    /**
     * The user is disabled.
     */
    DISABLED;
}
