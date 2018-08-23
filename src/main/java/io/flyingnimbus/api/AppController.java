package io.flyingnimbus.api;

import com.google.common.collect.ImmutableSortedMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Kye
 */
@RestController
public class AppController {

    @GetMapping(value = "/admin/stats")
    public Map stats() {
        return ImmutableSortedMap.of(
                "authentication", "basic",
                "authorization", "ADMIN role",
                "description", "an '/admin/**' endpoint where user is authenticated and only system admins should access");
    }

    @GetMapping(value = "/api/add")
    public Map add() {
        return ImmutableSortedMap.of(
                "authentication", "basic",
                "authorization", "all roles permitted",
                "description", "an '/api/**' endpoint where user is authenticated and all users can access");
    }

    @GetMapping(value = "/about")
    public Map about() {
        return ImmutableSortedMap.of(
                "authentication", "none",
                "authorization", "n/a",
                "description", "an '/about' endpoint where we probably want everyone to access");
    }
}