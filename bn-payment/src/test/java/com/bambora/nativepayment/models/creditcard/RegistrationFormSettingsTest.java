package com.bambora.nativepayment.models.creditcard;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationFormSettingsTest {

    private static final String KEY_PLATFORM = "platform";
    private static final String KEY_CSS_URL = "cssurl";
    private static final String KEY_SUBMIT_BUTTON = "submitbutton";
    private static final String KEY_CARD_NUMBER = "cardNumber";
    private static final String KEY_CARD_EXPIRY = "cardExpiry";
    private static final String KEY_SECURITY_CODE = "cardVerification";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLACEHOLDER = "placeholder";

    @Test
    public void testPlatformShouldBeSet() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            Assert.assertEquals("android", jsonObject.get(KEY_PLATFORM));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testCssUrlShouldNotBeSetByDefault() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
        try {
            jsonObject.get(KEY_CSS_URL);
            Assert.fail("Keys " + KEY_CSS_URL + " should not be set by default.");
        } catch (JSONException e) {
            // Expected exception
        }
    }

    @Test
    public void testCustomCssUrl() {
        // Given
        String customValue = "http://custom.url.com";
        RegistrationFormSettings formSettings = new RegistrationFormSettings();
        formSettings.setCssUrl(customValue);

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            Assert.assertEquals(customValue, jsonObject.getString(KEY_CSS_URL));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testSubmitButtonShouldNotBeSetByDefault() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
        try {
            jsonObject.get(KEY_SUBMIT_BUTTON);
            Assert.fail("Keys " + KEY_SUBMIT_BUTTON + " should not be set by default.");
        } catch (JSONException e) {
            // Expected exception
        }
    }

    @Test
    public void testCustomSubmitButton() {
        // Given
        String customValue = "Register here";
        RegistrationFormSettings formSettings = new RegistrationFormSettings();
        formSettings.setSubmitButtonText(customValue);

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            Assert.assertEquals(customValue, jsonObject.getString(KEY_SUBMIT_BUTTON));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testDefaultCardNumberPlaceholder() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject cardNumberObject = jsonObject.getJSONObject(KEY_CARD_NUMBER);
            Assert.assertEquals("cardnumber", cardNumberObject.getString(KEY_NAME));
            Assert.assertTrue(cardNumberObject.getString(KEY_PLACEHOLDER).isEmpty());
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testCustomCardNumberPlaceholder() {
        // Given
        String customHint = "Card number";
        RegistrationFormSettings formSettings = new RegistrationFormSettings();
        formSettings.setCardNumberInputHint(customHint);

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject cardNumberObject = jsonObject.getJSONObject(KEY_CARD_NUMBER);
            Assert.assertEquals(customHint, cardNumberObject.getString(KEY_PLACEHOLDER));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testDefaultCardExpiryPlaceholder() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject cardExpiryObject = jsonObject.getJSONObject(KEY_CARD_EXPIRY);
            Assert.assertEquals("cardexpiry", cardExpiryObject.getString(KEY_NAME));
            Assert.assertTrue(cardExpiryObject.getString(KEY_PLACEHOLDER).isEmpty());
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testCustomCardExpiryPlaceholder() {
        // Given
        String customHint = "Card expiry";
        RegistrationFormSettings formSettings = new RegistrationFormSettings();
        formSettings.setCardExpiryInputHint(customHint);

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject cardExpiryObject = jsonObject.getJSONObject(KEY_CARD_EXPIRY);
            Assert.assertEquals(customHint, cardExpiryObject.getString(KEY_PLACEHOLDER));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testDefaultSecurityCodePlaceholder() {
        // Given
        RegistrationFormSettings formSettings = new RegistrationFormSettings();

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject securityCodeObject = jsonObject.getJSONObject(KEY_SECURITY_CODE);
            Assert.assertEquals("cardverification", securityCodeObject.getString(KEY_NAME));
            Assert.assertTrue(securityCodeObject.getString(KEY_PLACEHOLDER).isEmpty());
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

    @Test
    public void testCustomSecurityCodePlaceholder() {
        // Given
        String customHint = "Security code";
        RegistrationFormSettings formSettings = new RegistrationFormSettings();
        formSettings.setCvvInputHint(customHint);

        // When
        String json = formSettings.getSerialized();

        // Then
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject securityCodeObject = jsonObject.getJSONObject(KEY_SECURITY_CODE);
            Assert.assertEquals(customHint, securityCodeObject.getString(KEY_PLACEHOLDER));
        } catch (JSONException exception) {
            Assert.fail("Generated JSON was invalid: " + exception.getMessage());
        }
    }

}
