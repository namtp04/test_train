package nam.dev.test_training.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nam.dev.test_training.dto.request.AuthenticationRequest;
import nam.dev.test_training.dto.response.AuthenticationResponse;
import nam.dev.test_training.entity.Category;
import nam.dev.test_training.exception.AddException;
import nam.dev.test_training.exception.ErrorCode;
import nam.dev.test_training.repo.CategoryRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationService {
    CategoryRepo categoryRepo;
    public AuthenticationResponse authentication(AuthenticationRequest request){
        Category cateName = categoryRepo.findById(request.getId())
                .orElseThrow(()->new AddException(ErrorCode.CATEGORY_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return AuthenticationResponse.builder()
                .isAuthenticated(passwordEncoder.matches(request.getCateName(),cateName.getCateName()))
                .build()
                ;
    }
}
