package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TermsAndConditions extends AppCompatActivity {

    private TextView mTerms;
    private final String Description = "<div class>" +
            "<h5>1. TERMS OF USE</h5>" +
            "<p>By downloading, browsing, accessing or using this Sample Store mobile application (&ldquo;<strong>Mobile Application</strong>&rdquo;), you agree to be bound by these Terms and Conditions of Use. We reserve the right to amend these terms and conditions at any time. If you disagree with any of these Terms and Conditions of Use, you must immediately discontinue your access to the Mobile Application and your use of the services offered on the Mobile Application. Continued use of the Mobile Application will constitute acceptance of these Terms and Conditions of Use, as may be amended from time to time.</p>" +
            "<h5>2. DEFINITIONS</h5>" +
            "<p>In these Terms and Conditions of Use, the following capitalised terms shall have the following meanings, except where the context otherwise requires:</p>" +
            "<p>\"<strong>Account</strong>\" means an account created by a User on the Mobile Application as part of Registration.</p>" +
            "<p>\"<strong>Merchant</strong>\" refers to any entity whose products or Samples can be purchased and/or redeemed (as the case may be) via the Mobile Application.</p>" +
            "<p>\"<strong>Privacy Policy</strong>\" means the privacy policy set out in Clause 14 of these Terms and Conditions of Use.</p>" +
            "<p>\"<strong>Redeem</strong>\" means to redeem a Merchant&rsquo;s products or Samples on these Terms and Conditions of Use and</p>" +
            "<p>\"<strong>Redemption</strong>\" means the act of redeeming such products or Samples.</p>" +
            "<p>\"<strong>Register</strong>\" means to create an Account on the Mobile Application and \"Registration\" means the act of creating such an Account.</p>" +
            "<p>\"<strong>Samples</strong>\" means samples of Merchant&rsquo;s products and/or Merchant&rsquo;s services, including without limitation, any vouchers for the redemption of such services, and \"Sample\" means any one of them.</p>" +
            "<p>\"<strong>Services</strong>\" means all the services provided by Singapore Post Limited via the Mobile Application to Users, and \"Service\" means any one of them,</p>" +
            "<p>\"<strong>Users</strong>\" means users of the Mobile Application, including you and \"User\" means any one of them.</p>" +
            "<h5>3. GENERAL ISSUES ABOUT THE MOBILE APPLICATION AND THE SERVICES</h5>" +
            "<p>3.1 <em>Applicability of terms and conditions</em>: The use of any Services and/or the Mobile Application and the making of any Redemptions are subject to these Terms and Conditions of Use.</p>" +
            "<p>3.2 <em>Location</em>: The Mobile Application, the Services and any Redemptions are intended solely for use by Users who access the Mobile Application in Singapore. We make no representation that the Services (or any goods or services) are available or otherwise suitable for use outside of Singapore. Notwithstanding the above, if you access the Mobile Application, use the Services or make any Redemptions from locations outside Singapore, you do so on your own initiative and are responsible for the consequences and for compliance with all applicable laws.</p>" +
            "<p>3.3 <em>Scope</em>: The Mobile Application, the Services and any Redemptions are for your non-commercial, personal use only and must not be used for business purposes.</p>" +
            "<p>3.4 <em>Prevention on use</em>: We reserve the right to prevent you using the Mobile Application and the Service (or any part of them) and to prevent you from making any Redemptions.</p>" +
            "<p>3.5 <em>Equipment and Networks</em>: The provision of the Services and the Mobile Application does not include the provision of a mobile telephone or handheld device or other necessary equipment to access the Mobile Application or the Services or make any Redemptions. To use the Mobile Application or Services or to make Redemptions, you will require Internet connectivity and appropriate telecommunication links. You acknowledge that the terms of agreement with your respective mobile network provider (\"<strong>Mobile Provider</strong>\") will continue to apply when using the Mobile Application. As a result, you may be charged by the Mobile Provider for access to network connection services for the duration of the connection while accessing the Mobile Application or any such third party charges as may arise. You accept responsibility for any such charges that arise.</p>" +
            "<p>3.6 <em>Permission to use Mobile Application</em>: If you are not the bill payer for the mobile telephone or handheld device being used to access the Mobile Application, you will be assumed to have received permission from the bill payer for using the Mobile Application.</p>" +
            "<p>3.7 <em>License to Use Material</em>: By submitting any text or images (including photographs) (&ldquo;<strong>Material</strong>&rdquo;) via the Application, you represent that you are the owner of the Material, or have proper authorization from the owner of the Material to use, reproduce and distribute it. You hereby grant us a worldwide, royalty-free, non-exclusive license to use the Material to promote any products or services.</p>" +
            "<h5>4. REDEMPTIONS</h5>" +
            "<p>4.1 <em>Need for registration</em>: You must Register to make a Redemption from the Mobile Application.</p>" +
            "<p>4.2 <em>Application of these Terms and Conditions of Use</em>: By making any Redemption, you acknowledge that the Redemption is subject to these Terms and Conditions of Use.</p>" +
            "<p>4.3 <em>Redemption</em>: Any attempted Redemption not consistent with these Terms and Conditions of Use may be disallowed or rendered void at our or the relevant Merchant&rsquo;s discretion.</p>" +
            "<p>4.4 <em>Responsibility for Redemptions of perishable products of Samples</em>: Each Merchant shall be responsible to ensure that any of its products or Samples for Redemption that are perishable has not expired.</p>" +
            "<p>4.5 <em>Restrictions</em>: (a) Reproduction, sale, resale or trading of any products or Samples or Redeemed products is prohibited. (b) If any product or Sample is Redeemed for less than its face value, there is no entitlement to a credit, cash or Sample equal to the difference between the face value and the amount Redeemed. (c) Redemption of products or Samples is subject to availability of the relevant Merchants&rsquo; stocks.</p>" +
            "<p>4.6 <em>SingPost Not Liable</em>: For the avoidance of doubt, Singapore Post Limited shall not be liable for any losses or damages suffered by you resulting from a failure by the relevant Merchant to fulfil any Redemptions in accordance with Clause 4.4 or for a failure by us to deliver any products or Samples to you due to the unavailability of such products or Samples pursuant to Clause 4.5(c).</p>" +
            "<p>4.7 <em>Lost/stolen Samples</em>: Neither we nor any Merchant shall be responsible for lost or stolen Samples or products that have been Redeemed.</p>" +
            "<h5>5. LOCATION ALERTS AND NOTIFICATIONS</h5>" +
            "<p>5.1 You agree to receive pre-programmed notifications (&ldquo;Location Alerts&rdquo;) on the Mobile Application from Merchants if you have turned on locational services on your mobile telephone or other handheld devices (as the case may be).</p>" +
            "<h5>6. YOUR OBLIGATIONS</h5>" +
            "<p>6.1 <em>Merchant terms</em>: You agree to (and shall) abide by the terms and conditions of the relevant Merchant for which your Redemption relates to, as may be amended from time to time.</p>" +
            "<p>6.2 <em>Accurate information</em>: You warrant that all information provided on Registration and contained as part of your Account is true, complete and accurate and that you will promptly inform us of any changes to such information by updating the information in your Account.</p>" +
            "<p>6.3 <em>Content on the Mobile Application and Service</em>: It is your responsibility to ensure that any products, Samples or information available through the Mobile Application or the Services meet your specific requirements before making any Redemption.</p>" +
            "<p>6.4 <em>Prohibitions in relation to usage of Services or Mobile Application</em>: Without limitation, you undertake not to use or permit anyone else to use the Services or Mobile Application:-</p>" +
            "<p>6.4.1 to send or receive any material which is not civil or tasteful</p>" +
            "<p>6.4.2 to send or receive any material which is threatening, grossly offensive, of an indecent, obscene or menacing character, blasphemous or defamatory of any person, in contempt of court or in breach of confidence, copyright, rights of personality, publicity or privacy or any other third party rights;</p>" +
            "<p>6.4.3 to send or receive any material for which you have not obtained all necessary licences and/or approvals (from us or third parties); or which constitutes or encourages conduct that would be considered a criminal offence, give rise to civil liability, or otherwise be contrary to the law of or infringe the rights of any third party in any country in the world;</p>" +
            "<p>6.4.4 to send or receive any material which is technically harmful (including computer viruses, logic bombs, Trojan horses, worms, harmful components, corrupted data or other malicious software or harmful data);</p>" +
            "<p>6.4.5 to cause annoyance, inconvenience or needless anxiety;</p>" +
            "<p>6.4.6 to intercept or attempt to intercept any communications transmitted by way of a telecommunications system;</p>" +
            "<p>6.4.7 for a purpose other than which we have designed them or intended them to be used;</p>" +
            "<p>6.4.8 for any fraudulent purpose;</p>" +
            "<p>6.4.9 other than in conformance with accepted Internet practices and practices of any connected networks;</p>" +
            "<p>6.4.10 in any way which is calculated to incite hatred against any ethnic, religious or any other minority or is otherwise calculated to adversely affect any individual, group or entity; or</p>" +
            "<p>6.4.11 in such a way as to, or commit any act that would or does, impose an unreasonable or disproportionately large load on our infrastructure.</p>" +
            "<p>6.5 <em>Prohibitions in relation to usage of Services, Mobile Application</em>: Without limitation, you further undertake not to or permit anyone else to:-</p>" +
            "<p>6.5.1 resell any products or Samples ;</p>" +
            "<p>6.5.2 furnish false data including false names, addresses and contact details and fraudulently use credit/debit card numbers;</p>" +
            "<p>6.5.3 attempt to circumvent our security or network including to access data not intended for you, log into a server or account you are not expressly authorised to access, or probe the security of other networks (such as running a port scan);</p>" +
            "<p>6.5.4 execute any form of network monitoring which will intercept data not intended for you;</p>" +
            "<p>6.5.5 enter into fraudulent interactions or transactions with us or a Merchant (including interacting or transacting purportedly on behalf of a third party where you have no authority to bind that third party or you are pretending to be a third party);</p>" +
            "<p>6.5.6 extract data from or hack into the Mobile Application;</p>" +
            "<p>6.5.7 use the Services or Mobile Application in breach of these Terms and Conditions of Use;</p>" +
            "<p>6.5.8 engage in any unlawful activity in connection with the use of the Mobile Application or the Services; or</p>" +
            "<p>6.5.9 engage in any conduct which, in our exclusive reasonable opinion, restricts or inhibits any other customer from properly using or enjoying the Mobile Application or Services.</p>" +
            "<h5>7. RULES ABOUT USE OF THE SERVICE AND THE MOBILE APPLICATION</h5>" +
            "<p>7.1 We will use reasonable endeavours to correct any errors or omissions as soon as practicable after being notified of them. However, we do not guarantee that the Services or the Mobile Application will be free of faults, and we do not accept liability for any such faults, errors or omissions. In the event of any such error, fault or omission, you should report it by contacting us at 6844 0092.</p>" +
            "<p>7.2 We do not warrant that your use of the Services or the Mobile Application will be uninterrupted and we do not warrant that any information (or messages) transmitted via the Services or the Mobile Application will be transmitted accurately, reliably, in a timely manner or at all. Notwithstanding that we will try to allow uninterrupted access to the Services and the Mobile Application, access to the Services and the Mobile Application may be suspended, restricted or terminated at any time.</p>" +
            "<p>7.3 We do not give any warranty that the Services and the Mobile Application are free from viruses or anything else which may have a harmful effect on any technology.</p>" +
            "<p>7.4 We reserve the right to change, modify, substitute, suspend or remove without notice any information or Services on the Mobile Application from time to time. Your access to the Mobile Application and/or the Services may also be occasionally restricted to allow for repairs, maintenance or the introduction of new facilities or services. We will attempt to restore such access as soon as we reasonably can. For the avoidance of doubt, we reserve the right to withdraw any information or Services from the Mobile Application at any time.</p>" +
            "<p>7.5 We reserve the right to block access to and/or to edit or remove any material which in our reasonable opinion may give rise to a breach of these Terms and Conditions of Use.</p>" +
            "</div>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        getIntent();
        mTerms = findViewById(R.id.terms_text);
        mTerms.setText(Html.fromHtml(Description));

    }
}
