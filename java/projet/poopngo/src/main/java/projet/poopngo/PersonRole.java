package projet.poopngo;

import org.springframework.security.core.GrantedAuthority;

/**
 * UserRole
 */
public enum PersonRole implements GrantedAuthority {
    
    USER,
    MODERATEUR,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_"+this.name();
    }
}
