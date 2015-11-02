/*
 * Copyright 2015 Lipisha Consortium Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lipisha.sdk.api;

import com.lipisha.sdk.response.*;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import java.util.Date;

/**
 * <p>Sets up a JAVA interface to the Lipisha API</p>
 * <p/>
 * <p>See API documentation here: http://developer.lipisha.com/index.php/app/launch/api</p>
 */
public interface LipishaAPI {

    @FormUrlEncoded
    @POST("/index.php/v2/api/get_balance")
    AccountBalance getBalance(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                              @Field("api_version") String apiVersion, @Field("api_type") String apiType);

    @FormUrlEncoded
    @POST("/index.php/v2/api/get_float")
    AccountFloat getFloat(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                          @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                          @Field("account_number") String accountNumber);

    @FormUrlEncoded
    @POST("/index.php/v2/api/send_money")
    Payout sendMoney(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                     @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                     @Field("account_number") String accountNumber, @Field("mobile_number") String mobileNumber,
                     @Field("amount") int amount);

    @FormUrlEncoded
    @POST("/index.php/v2/api/send_airtime")
    AirtimeDisbursement sendAirtime(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                    @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                    @Field("account_number") String accountNumber, @Field("mobile_number") String mobileNumber,
                                    @Field("amount") int airtimeAmount, @Field("network") String network);

    @FormUrlEncoded
    @POST("/index.php/v2/api/send_sms")
    SMSReport sendSMS(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                      @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                      @Field("account_number") String accountNumber, @Field("mobile_number") String mobileNumber,
                      @Field("message") String message);

    @FormUrlEncoded
    @POST("/index.php/v2/api/acknowledge_transaction")
    TransactionResponse confirmTransaction(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                           @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                           @Field("transaction") String transactionIds);

    @FormUrlEncoded
    @POST("/index.php/v2/api/reconcile_transaction")
    TransactionResponse reconcileTransaction(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                             @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                             @Field("transaction") String transactionId,
                                             @Field("transaction_mobile_number") String mobileNumber,
                                             @Field("transaction_account_number") String accountNumber,
                                             @Field("transaction_reference") String reference);

    @FormUrlEncoded
    @POST("/index.php/v2/api/reverse_transaction")
    MultiTransactionResponse reverseTransaction(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                                @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                                @Field("transaction") String transactionIds);

    @FormUrlEncoded
    @POST("/index.php/v2/api/get_transactions")
    MultiTransactionResponse getTransactions(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                             @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                             @Field("transaction") String transactionIds,
                                             @Field("transaction_type") String transactionTypes,
                                             @Field("transaction_method") String transactionMethods,
                                             @Field("transaction_date_start") Date transactionDateStart,
                                             @Field("transaction_date_end") Date transactionDateEnd,
                                             @Field("transaction_account_name") String transactionAccountNames,
                                             @Field("transaction_account_number") String transactionAccountNumbers,
                                             @Field("transaction_reference") String transactionReferences,
                                             @Field("transaction_amount_minimum") Float transactionAmountMinimum,
                                             @Field("transaction_amount_maximum") Float transactionAmountMaximum,
                                             @Field("transaction_status") String transactionStatuses,
                                             @Field("transaction_name") String transactionName,
                                             @Field("transaction_mobile_number") String transactionMobileNumber,
                                             @Field("transaction_email") String transactionEmail,
                                             @Field("limit") int limit,
                                             @Field("offset") int offset);

    @FormUrlEncoded
    @POST("/index.php/v2/api/get_customers")
    CustomerResponse getCustomers(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                  @Field("api_version") String apiVersion, @Field("api_type") String apiType);

    @FormUrlEncoded
    @POST("/index.php/v2/api/create_payment_account")
    TransactionAccountResponse createTransactionAccount(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                                        @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                                        @Field("transaction_account_type") int accountType,
                                                        @Field("transaction_account_name") String accountName,
                                                        @Field("transaction_account_manager") String accountManager);

    @FormUrlEncoded
    @POST("/index.php/v2/api/create_withdrawal_account")
    WithdrawalAccountResponse createWithdrawalAccount(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                                                      @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                                                      @Field("transaction_account_type") int accountType,
                                                      @Field("transaction_account_name") String accountName,
                                                      @Field("transaction_account_manager") String accountManager,
                                                      @Field("transaction_account_number") String accountNumber,
                                                      @Field("transaction_account_bank_name") String bankName,
                                                      @Field("transaction_account_bank_branch") String bankBranch,
                                                      @Field("transaction_account_bank_address") String bankAddress,
                                                      @Field("transaction_account_swift_code") String swiftCode);

    @FormUrlEncoded
    @POST("/index.php/v2/api/create_user")
    UserResponse createUser(@Field("api_key") String apiKey, @Field("api_signature") String apiSignature,
                            @Field("api_version") String apiVersion, @Field("api_type") String apiType,
                            @Field("full_name") String fullName,
                            @Field("role") String role,
                            @Field("email") String email,
                            @Field("mobile_number") String mobileNumber,
                            @Field("user_name") String userName,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("/index.php/v2/api/authorize_card_transaction")
    CardTransactionResponse authorizeCardTransaction(@Field("api_key") String apiKey,
                                                     @Field("api_signature") String apiSignature,
                                                     @Field("api_version") String apiVersion,
                                                     @Field("api_type") String apiType,
                                                     @Field("account_number") String accountNumber,
                                                     @Field("card_number") String cardNumber,
                                                     @Field("address1") String address1,
                                                     @Field("address2") String address2,
                                                     @Field("expiry") String expiry,
                                                     @Field("name") String name,
                                                     @Field("state") String state,
                                                     @Field("country") String country,
                                                     @Field("zip") String zipCode,
                                                     @Field("security_code") String securityCode,
                                                     @Field("amount") Float amount,
                                                     @Field("currency") String currency);


    @FormUrlEncoded
    @POST("/index.php/v2/api/complete_card_transaction")
    CardTransactionResponse completeCardTransaction(@Field("api_key") String apiKey,
                                                    @Field("api_signature") String apiSignature,
                                                    @Field("api_version") String apiVersion,
                                                    @Field("api_type") String apiType,
                                                    @Field("transaction_index") String accountNumber,
                                                    @Field("transaction_reference") String cardNumber);

    @FormUrlEncoded
    @POST("/index.php/v2/api/reverse_card_transaction")
    CardTransactionResponse reverseCardTransaction(@Field("api_key") String apiKey,
                                                   @Field("api_signature") String apiSignature,
                                                   @Field("api_version") String apiVersion,
                                                   @Field("api_type") String apiType,
                                                   @Field("transaction_index") String accountNumber,
                                                   @Field("transaction_reference") String cardNumber);
}
