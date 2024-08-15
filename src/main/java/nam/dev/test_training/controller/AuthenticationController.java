package nam.dev.test_training.controller;

import lombok.RequiredArgsConstructor;
import nam.dev.test_training.dto.request.AuthenticationRequest;
import nam.dev.test_training.dto.response.ApiResponse;
import nam.dev.test_training.dto.response.AuthenticationResponse;
import nam.dev.test_training.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public ApiResponse<AuthenticationResponse> authLogin(@RequestBody AuthenticationRequest request) {
        return ApiResponse.<AuthenticationResponse>builder()
                .code(1000)
                .result(
                       authenticationService.authentication(request))
                .build();

    }
}
