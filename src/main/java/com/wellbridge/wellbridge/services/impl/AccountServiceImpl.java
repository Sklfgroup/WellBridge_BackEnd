package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.exceptions.ResourceNotFoundException;
import com.wellbridge.wellbridge.rest.dto.requests.account.UpdateAccountRequest;
import com.wellbridge.wellbridge.security.jwt.JwtTokenUtil;
import com.wellbridge.wellbridge.services.AccountService;
import com.wellbridge.wellbridge.services.email.EmailService;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder,
                              JwtTokenUtil jwtTokenUtil, EmailService emailService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.emailService = emailService;
    }

    private boolean isValidEmail(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private void sendPasswordEmail(String email, String password) {
        String subject = "Votre compte a été créé";
        String text = "Votre mot de passe est : " + password;
        emailService.sendEmail(email, subject, text);
    }

    private void createAndSaveAccount(AccountEntity account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        String rawPassword = generatePassword();
        account.setPassword(passwordEncoder.encode(rawPassword));
        accountRepository.save(account);
        sendPasswordEmail(account.getUsername(), rawPassword);
    }
    /*@Override
    public AccountEntity createAdminAccount(AccountEntity adminAccount) {
        if (adminAccount.getUserRole() != UserRole.ADMINISTRATOR) {
            throw new IllegalArgumentException("Only ADMINISTRATOR accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(adminAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        adminAccount.setPassword(passwordEncoder.encode(adminAccount.getPassword()));
        return accountRepository.save(adminAccount);
    }*/

    @Override
    public AccountEntity createAdminAccount(AccountEntity adminAccount) {
        if (!isValidEmail(adminAccount.getUsername())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (adminAccount.getUserRole() != UserRole.ADMINISTRATOR) {
            throw new IllegalArgumentException("Only ADMINISTRATOR accounts can be created with this method");
        }
        createAndSaveAccount(adminAccount);
        return adminAccount;
    }

    @Override
    public AccountEntity createPatientAccount(AccountEntity patientAccount) {
        if (!isValidEmail(patientAccount.getUsername())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (patientAccount.getUserRole() != UserRole.PATIENT) {
            throw new IllegalArgumentException("Only PATIENT accounts can be created with this method");
        }
        createAndSaveAccount(patientAccount);
        return patientAccount;
    }




    @Override
    public AccountEntity updateAccount(String uuid, UpdateAccountRequest request) {
        AccountEntity account = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (request.getFirstname() != null) account.setFirstname(request.getFirstname());
        if (request.getLastname() != null) account.setLastname(request.getLastname());
        if (request.getUsername() != null) account.setUsername(request.getUsername());
        if (request.getNumber() != null) account.setNumber(request.getNumber());
        if (request.getAdresse() != null) account.setAdresse(request.getAdresse());

        return accountRepository.save(account);
    }

    @Override
    public AccountEntity getAccountByUuid(String uuid) {
        return accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with uuid " + uuid));
    }

   /*@Override
    public AccountEntity createPatientAccount(AccountEntity patientAccount) {
        if (patientAccount.getUserRole() != UserRole.PATIENT) {
            throw new IllegalArgumentException("Only PATIENT accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(patientAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        patientAccount.setPassword(passwordEncoder.encode(patientAccount.getPassword()));

       // Création de l'information médicale
       MedicalInfo medicalInfo = new MedicalInfo();
       medicalInfo.setAccount(patientAccount);
       patientAccount.setMedicalInfo(medicalInfo);

        return accountRepository.save(patientAccount);
    }*/

    @Override
    public AccountEntity createMedecinAccount(AccountEntity medecinAccount) {
        if (!isValidEmail(medecinAccount.getUsername())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (medecinAccount.getUserRole() != UserRole.MEDECIN) {
            throw new IllegalArgumentException("Only MEDECIN accounts can be created with this method");
        }
        createAndSaveAccount(medecinAccount);
        return medecinAccount;
    }







   /* @Override
    public AccountEntity createMedecinAccount(AccountEntity medecinAccount) {
        if (medecinAccount.getUserRole() != UserRole.MEDECIN) {
            throw new IllegalArgumentException("Only MEDECIN accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(medecinAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        medecinAccount.setPassword(passwordEncoder.encode(medecinAccount.getPassword()));
        return accountRepository.save(medecinAccount);
    }*/







    @Override
    public AccountEntity getAccountByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with username " + username));
    }

    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<AccountEntity> getAccountsByRole(UserRole role) {
        return accountRepository.findByUserRole(role);
    }



    @Override
    public AccountEntity authenticate(String username, String password) {
        AccountEntity account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with username " + username));

        if (passwordEncoder.matches(password, account.getPassword())) {
            account.setToken(jwtTokenUtil.generateToken(account));
            return account;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}
