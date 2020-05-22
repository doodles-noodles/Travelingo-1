package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class PrivacyPolicy extends AppCompatActivity {

    private TextView mPolicy;
    private final String Policy = "<div class=\"col-half-right\">" +
            "<h5>8. SUSPENSION AND TERMINATION</h5>" +
            "<p>8.1 If you use (or anyone other than you, with your permission uses) the Mobile Application, any Services in contravention of these Terms and Conditions of Use, we may suspend your use of the Services and/or Mobile Application.</p>" +
            "<p>8.2 If we suspend the Services or Mobile Application, we may refuse to restore the Services or Mobile Application for your use until we receive an assurance from you, in a form we deem acceptable, that there will be no further breach of the provisions of these Terms and Conditions of Use.</p>" +
            "<p>8.3 Singapore Post Limited shall fully co-operate with any law enforcement authorities or court order requesting or directing Singapore Post Limited to disclose the identity or locate anyone in breach of these Terms and Conditions of Use.</p>" +
            "<p>8.4 Without limitation to anything else in this Clause 8, we shall be entitled immediately or at any time (in whole or in part) to: (a) suspend the Services and/or Mobile Application; (b) suspend your use of the Services and/or Mobile Application; and/or (c) suspend the use of the Services and/or Mobile Application for persons we believe to be connected (in whatever manner) to you, if:</p>" +
            "<p>8.4.1 you commit any breach of these Terms and Conditions of Use;</p>" +
            "<p>8.4.2 we suspect, on reasonable grounds, that you have, might or will commit a breach of these Terms and Conditions of Use; or</p>" +
            "<p>8.4.3 we suspect, on reasonable grounds, that you may have committed or be committing any fraud against us or any person.</p>" +
            "<p>8.5 Our rights under this Clause 8 shall not prejudice any other right or remedy we may have in respect of any breach or any rights, obligations or liabilities accrued prior to termination.</p>" +
            "<h5>9. DISCLAIMER AND EXCLUSION OF LIABILITY</h5>" +
            "<p>9.1 The Mobile Application, the Services, the information on the Mobile Application and use of all related facilities are provided on an \"as is, as available\" basis without any warranties whether express or implied.</p>" +
            "<p>9.2 To the fullest extent permitted by applicable law, we disclaim all representations and warranties relating to the Mobile Application and its contents, including in relation to any inaccuracies or omissions in the Mobile Application, warranties of merchantability, quality, fitness for a particular purpose, accuracy, availability, non-infringement or implied warranties from course of dealing or usage of trade.</p>" +
            "<p>9.3 We do not warrant that the Mobile Application will always be accessible, uninterrupted, timely, secure, error free or free from computer virus or other invasive or damaging code or that the Mobile Application will not be affected by any acts of God or other force majeure events, including inability to obtain or shortage of necessary materials, equipment facilities, power or telecommunications, lack of telecommunications equipment or facilities and failure of information technology or telecommunications equipment or facilities.</p>" +
            "<p>9.4 While we may use reasonable efforts to include accurate and up-to-date information on the Mobile Application, we make no warranties or representations as to its accuracy, timeliness or completeness.</p>" +
            "<p>9.5 We shall not be liable for any acts or omissions of any third parties howsoever caused, and for any direct, indirect, incidental, special, consequential or punitive damages, howsoever caused, resulting from or in connection with the mobile application and the services offered in the mobile application, your access to, use of or inability to use the mobile application or the services offered in the mobile application, reliance on or downloading from the mobile application and/or services, or any delays, inaccuracies in the information or in its transmission including but not limited to damages for loss of business or profits, use, data or other intangible, even if we have been advised of the possibility of such damages.</p>" +
            "<p>9.6 We shall not be liable in contract, tort (including negligence or breach of statutory duty) or otherwise howsoever and whatever the cause thereof, for any indirect, consequential, collateral, special or incidental loss or damage suffered or incurred by you in connection with the Mobile Application and these Terms and Conditions of Use. For the purposes of these Terms and Conditions of Use, indirect or consequential loss or damage includes, without limitation, loss of revenue, profits, anticipated savings or business, loss of data or goodwill, loss of use or value of any equipment including software, claims of third parties, and all associated and incidental costs and expenses.</p>" +
            "<p>9.7 The above exclusions and limitations apply only to the extent permitted by law. None of your statutory rights as a consumer that cannot be excluded or limited are affected.</p>" +
            "<p>9.8 Notwithstanding our efforts to ensure that our system is secure, you acknowledge that all electronic data transfers are potentially susceptible to interception by others. We cannot, and do not, warrant that data transfers pursuant to the Mobile Application, or electronic mail transmitted to and from us, will not be monitored or read by others.</p>" +
            "<h5>10. INDEMNITY</h5>" +
            "<p>You agree to indemnify and keep us indemnified against any claim, action, suit or proceeding brought or threatened to be brought against us which is caused by or arising out of (a) your use of the Services, (b) any other party&rsquo;s use of the Services using your user ID, verification PIN and/or any identifier number allocated by Singapore Post Limited, and/or (c) your breach of any of these Terms and Conditions of Use, and to pay us damages, costs and interest in connection with such claim, action, suit or proceeding.</p>" +
            "<h5>11. INTELLECTUAL PROPERTY RIGHTS</h5>" +
            "<p>11.1 All editorial content, information, photographs, illustrations, artwork and other graphic materials, and names, logos and trade marks on the Mobile Application are protected by copyright laws and/or other laws and/or international treaties, and belong to us and/or our suppliers, as the case may be. These works, logos, graphics, sounds or images may not be copied, reproduced, retransmitted, distributed, disseminated, sold, published, broadcasted or circulated whether in whole or in part, unless expressly permitted by us and/or our suppliers, as the case may be.</p>" +
            "<p>11.2 Nothing contained on the Mobile Application should be construed as granting by implication, estoppel, or otherwise, any license or right to use any trademark displayed on the Mobile Application without our written permission. Misuse of any trademarks or any other content displayed on the Mobile Application is prohibited.</p>" +
            "<p>11.3 We will not hesitate to take legal action against any unauthorised usage of our trade marks, name or symbols to preserve and protect its rights in the matter. All rights not expressly granted herein are reserved. Other product and company names mentioned herein may also be the trade marks of their respective owners.</p>" +
            "<h5>12. AMENDMENTS</h5>" +
            "<p>12.1 We may periodically make changes to the contents of the Mobile Application, including to the descriptions and prices of goods and services advertised, at any time and without notice. We assume no liability or responsibility for any errors or omissions in the content of the Mobile Application.</p>" +
            "<p>12.2 We reserve the right to amend these Terms and Conditions of Use from time to time without notice. The revised Terms and Conditions of Use will be posted on the Mobile Application and shall take effect from the date of such posting. You are advised to review these terms and conditions periodically as they are binding upon you.</p>" +
            "<h5>13. APPLICABLE LAW AND JURISDICTION</h5>" +
            "<p>13.1 The Mobile Application can be accessed from all countries around the world where the local technology permits. As each of these places have differing laws, by accessing the Mobile Application both you and we agree that the laws of the Republic of Singapore, without regard to the conflicts of laws principles thereof, will apply to all matters relating to the use of the Mobile Application.</p>" +
            "<p>13.2 You accept and agree that both you and we shall submit to the exclusive jurisdiction of the courts of the Republic of Singapore in respect of any dispute arising out of and/or in connection with these Terms and Conditions of Use.</p>" +
            "<h5>14. Privacy Policy</h5>" +
            "<p>14.1 Access to the Mobile Application and use of the Services offered on the Mobile Application by Singapore Post Limited and/or its group of companies is subject to this Privacy Policy. By accessing the Mobile Application and by continuing to use the Services offered, you are deemed to have accepted this Privacy Policy, and in particular, you are deemed to have consented to our use and disclosure of your personal information in the manner prescribed in this Privacy Policy and for the purposes set out in Clauses 3.7 and/or 4.1. We reserve the right to amend this Privacy Policy from time to time. If you disagree with any part of this Privacy Policy, you must immediately discontinue your access to the Mobile Application and your use of the Services.</p>" +
            "<p>14.2 As part of the normal operation of our Services, we collect, use and, in some cases, disclose information about you to third parties. Accordingly, we have developed this Privacy Policy in order for you to understand how we collect, use, communicate and disclose and make use of your personal information when you use the Services on the Mobile Application:-</p>" +
            "<p>(a) Before or at the time of collecting personal information, we will identify the purposes for which information is being collected.</p>" +
            "<p>(b) We will collect and use of personal information solely with the objective of fulfilling those purposes specified by us and for other compatible purposes, unless we obtain the consent of the individual concerned or as required by law.</p>" +
            "<p>(c) We will only retain personal information as long as necessary for the fulfillment of those purposes.</p>" +
            "<p>(d) We will collect personal information by lawful and fair means and, where appropriate, with the knowledge or consent of the individual concerned.</p>" +
            "<p>(e) Personal information should be relevant to the purposes for which it is to be used, and, to the extent necessary for those purposes, should be accurate, complete, and up-to-date.</p>" +
            "<p>(f) We will protect personal information by reasonable security safeguards against loss or theft, as well as unauthorized access, disclosure, copying, use or modification.</p>" +
            "<p>We are committed to conducting our business in accordance with these principles in order to ensure that the confidentiality of personal information is protected and maintained.</p>" +
            "</div>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        getIntent();
        mPolicy = findViewById(R.id.policy_text);
        mPolicy.setText(Html.fromHtml(Policy));
    }
}
