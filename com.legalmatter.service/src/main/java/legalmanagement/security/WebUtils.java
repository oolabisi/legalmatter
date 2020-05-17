package legalmanagement.security;

import legalmanagement.data.entity.Attorney;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class WebUtils {

    public static String toString(Attorney user) {
        StringBuilder sb = new StringBuilder();

        sb.append("Username:").append(user.getUsername());

        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
