
package entity;


/**
 * This enumeration is for users profiles. Includes the values USER and ADMIN.  
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Lopez de Uralde.
 */
public enum UserPrivilege{
    /**
     * The user is a {@link Boss}.
     */
    BOSS,
    /**
     * The user is an {@link Employee}.
     */
    EMPLOYEE,
    /**
     * The user is a {@link Visitor}.
     */
    VISITOR;
}
