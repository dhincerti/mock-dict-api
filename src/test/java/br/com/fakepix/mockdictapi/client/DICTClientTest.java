package br.com.fakepix.mockdictapi.client;

import br.com.fakepix.mockdictapi.domain.model.directory.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
class DICTClientTest {
    
    public static final String EMAIL = "key@email.com";
    public static final String ACCOUNT_NUMBER = "9284712020";
    public static final String ISBP = "IBSP_NAME";
    public static final String OWNER_NAME = "Owner Name";
    
    @Autowired
    DICTClient dictClient;
    
    @Test
    public void shouldRetrieveAnEntry() {
        String signature = UUID.randomUUID().toString();
        String key = signature + "-" + EMAIL;
        
        Account account = new Account();
        account.setAccountNumber(ACCOUNT_NUMBER);
        account.setParticipant(ISBP);
        
        Owner owner = new Owner();
        owner.setName(OWNER_NAME);
        
        Entry entry = new Entry();
        entry.setKey(key);
        entry.setKeyType(KeyType.EMAIL.name());
        entry.setAccount(account);
        entry.setOwner(owner);
        
        CreateEntryRequest request = new CreateEntryRequest(signature, entry);
        ResponseEntity createEntryResponse = dictClient.createEntry(request);
        assertThat(createEntryResponse.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(createEntryResponse.getBody(), notNullValue());
        
        ResponseEntity retrieveEntryResponse = dictClient.retrieveEntry(key, ISBP, key, signature);
        assertThat(retrieveEntryResponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(retrieveEntryResponse.getBody(), notNullValue());
        
    }
    
}