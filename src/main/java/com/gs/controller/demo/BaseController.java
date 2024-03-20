package com.gs.controller.demo;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Query success"),
        @ApiResponse(responseCode = "201", description = "Create success", content = @Content),
        @ApiResponse(responseCode = "400", description = "Request parameter missing", content = @Content),
        @ApiResponse(responseCode = "401", description = "Authentication failure", content = @Content),
        @ApiResponse(responseCode = "403", description = "Have no authority", content = @Content),
        @ApiResponse(responseCode = "404", description = "The request path does not exist", content = @Content),
        @ApiResponse(responseCode = "422", description = "The request parameter validation failed", content = @Content),
        @ApiResponse(responseCode = "444", description = "The account was logged in at another location and forced to logout", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public class BaseController {
}
