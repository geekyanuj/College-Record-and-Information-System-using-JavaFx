package Controller_FXMLController;

import Model_Beans.StudentAddressDetails;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class AddStudent2FXMLController implements Initializable {

    @FXML
    private JFXTextField presentAddressLine1TF;
    @FXML
    private JFXTextField presentCityNameTF;
    @FXML
    private JFXComboBox<String> presentStateNameComboBox;
    @FXML
    private JFXComboBox<String> presentDistrictNameComboBox;
    @FXML
    private JFXTextField presentPinCodeTF;
    @FXML
    private JFXTextField permanentAddressLine1TF;
    @FXML
    private JFXTextField permanentCityNameTF;
    @FXML
    private JFXComboBox<String> permanentStateNameComboBox;
    @FXML
    private JFXComboBox<String> permanentDistrictNameComboBox;
    @FXML
    private JFXTextField permanentPinCodeTF;

    String indianStates[] = new String[]
    {
        "Andaman and Nicobar", "Arunachal Pradesh", "Assam", "Bihar", "Chattisgarh", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu","Delhi (NCT)", "Goa", "Gujrat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep UT", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Puducherry UT", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttrakhand", "West Bengal"
    };
    
    String AndamanandNicobar[]={"	Nicobar","North and Middle Andaman","South Andaman"};
    
    String AndharaPradesh[] =
    {
        "Anantapur", "Chittoor", "East Godavari", "Guntur", "Krishna", "Kurnool", "Nellore", "Prakasam", "Srikakulam", "Visakhapatnam", "Vizianagaram", "West Godavari", "YSR Kadapa"
    };
    String ArunachalPradesh[] =
    {
        "Tawang", "West Kameng", "East Kameng", "Papum Pare", "Kurung Kumey", "Kra Daadi", "Lower Subansiri", "Upper Subansiri", "West Siang", "East Siang", "Siang", "Upper Siang", "Lower Siang", "Lower Dibang Valley", "Dibang Valley", "Anjaw", "Lohit", "Namsai", "Changlang", "Tirap", "Longding"
    };
    String Assam[] =
    {
        "Baksa", "Barpeta", "Biswanath", "Bongaigao,Cchar", "Charaideo", "Chirang", "Darrang", "Dhemaji", "Dhubri", "Dibrugarh", "Goalpara", "Golaghat", "Hailakandi", "Hojai", "Jorhat", "Kamrup Metropolita,Kmrup", "Karbi Anglong", "Karimganj", "Kokrajhar", "Lakhimpur", "Majuli", "Morigao,Ngao,Nlbari", "Dima Hasao", "Sivasagar", "Sonitpur", "South Salmara-Mankachar", "Tinsukia", "Udalguri", "West Karbi Anglong"
    };
    String Bihar[] =
    {
        "Araria", "Arwal", "Aurangabad", "Banka", "Begusarai", "Bhagalpur", "Bhojpur", "Buxar", "Darbhanga", "East Champaran (Motihari)", "Gaya", "Gopalganj", "Jamui", "Jehanabad", "Kaimur (Bhabua)", "Katihar", "Khagaria", "Kishanganj", "Lakhisarai", "Madhepura", "Madhubani", "Munger (Monghyr)", "Muzaffarpur", "Nalanda", "Nawada", "Patna", "Purnia (Purnea)", "Rohtas", "Saharsa", "Samastipur", "Saran", "Sheikhpura", "Sheohar", "Sitamarhi", "Siwan", "Spaul", "Vaishali", "West Champara"
    };
    String Chandigarh[] =
    {
        "Chandigarh(UT)"
    };
    String Chhattisgarh[] =
    {
        "Balod", "Baloda Bazar", "Balrampur", "Bastar", "Bemetara", "Bijapur", "Bilaspur", "Dantewada (South Bastar)", "Dhamtari", "Durg", "Gariyaband", "Janjgir-Champa", "Jashpur", "Kabirdham (Kawardha)", "Kanker (North Bastar)", "Kondagaon", "Korba", "Korea (Koriya)", "Mahasamund", "Mungeli", "Narayanpur", "Raigarh", "Raipur", "Rajnandgaon", "Sukma", "Surajpur  ", "Surguja"
    };
    String DadraandNagarHaveli[] =
    {
        "Dadra and Nagar Haveli (UT)"
    };
    String DamanandDiu[] =
    {
        "Daman", "Diu"
    };
    String DelhiNCT[] =
    {
        "Central Delhi", "East Delhi", "New Delhi", "North Delhi", "North East  Delhi", "North West  Delhi", "Shahdara", "South Delhi", "South East Delhi", "South West  Delhi", "West Delhi"
    };
    String Goa[] =
    {
        "North Goa", "South Goa"
    };
    String Gujarat[] =
    {
        "Ahmedabad",
        "Amreli",
        "Anand",
        "Aravalli",
        "Banaskantha (Palanpur)",
        "Bharuch",
        "Bhavnagar",
        "Botad",
        "Chhota Udepur",
        "Dahod",
        "Dangs (Ahwa)",
        "Devbhoomi Dwarka",
        "Gandhinagar",
        "Gir Somnath",
        "Jamnagar",
        "Junagadh",
        "Kachchh",
        "Kheda (Nadiad)",
        "Mahisagar",
        "Mehsana",
        "Morbi",
        "Narmada (Rajpipla)",
        "Navsari",
        "Panchmahal (Godhra)",
        "Patan",
        "Porbandar",
        "Rajkot",
        "Sabarkantha (Himmatnagar)",
        "Surat",
        "Surendranagar",
        "Tapi (Vyara)",
        "Vadodara",
        "Valsad"
    };
    String Haryana[]={"Ambala",
                "Bhiwani",
                "Charkhi Dadri",
                "Faridabad",
                "Fatehabad",
                "Gurgaon",
                "Hisar",
                "Jhajjar",
                "Jind",
                "Kaithal",
                "Karnal",
                "Kurukshetra",
                "Mahendragarh",
                "Mewat",
                "Palwal",
                "Panchkula",
                "Panipat",
                "Rewari",
                "Rohtak",
                "Sirsa",
                "Sonipat",
                "Yamunanagar"};
    
    String HimachalPradesh[]={"Bilaspur",
                "Chamba",
                "Hamirpur",
                "Kangra",
                "Kinnaur",
                "Kullu",
                "Lahaul &amp; Spiti",
                "Mandi",
                "Shimla",
                "Sirmaur (Sirmour)",
                "Solan",
                "Una"};
    
    String JammuandKashmir[]={"Anantnag",
                "Bandipore",
                "Baramulla",
                "Budgam",
                "Doda",
                "Ganderbal",
                "Jammu",
                "Kargil",
                "Kathua",
                "Kishtwar",
                "Kulgam",
                "Kupwara",
                "Leh",
                "Poonch",
                "Pulwama",
                "Rajouri",
                "Ramban",
                "Reasi",
                "Samba",
                "Shopian",
                "Srinagar",
                "Udhampur"};
    
    String Jharkhand[]={"Bokaro",
                "Chatra",
                "Deoghar",
                "Dhanbad",
                "Dumka",
                "East Singhbhum",
                "Garhwa",
                "Giridih",
                "Godda",
                "Gumla",
                "Hazaribag",
                "Jamtara",
                "Khunti",
                "Koderma",
                "Latehar",
                "Lohardaga",
                "Pakur",
                "Palamu",
                "Ramgarh",
                "Ranchi",
                "Sahibganj",
                "Seraikela-Kharsawan",
                "Simdega",
                "West Singhbhum"};
    
    String Karnataka[]={"Bagalkot",
                "Ballari (Bellary)",
                "Belagavi (Belgaum)",
                "Bengaluru (Bangalore) Rural",
                "Bengaluru (Bangalore) Urban",
                "Bidar",
                "Chamarajanagar",
                "Chikballapur",
                "Chikkamagaluru (Chikmagalur)",
                "Chitradurga",
                "Dakshina Kannada",
                "Davangere",
                "Dharwad",
                "Gadag",
                "Hassan",
                "Haveri",
                "Kalaburagi (Gulbarga)",
                "Kodagu",
                "Kolar",
                "Koppal",
                "Mandya",
                "Mysuru (Mysore)",
                "Raichur",
                "Ramanagara",
                "Shivamogga (Shimoga)",
                "Tumakuru (Tumkur)",
                "Udupi",
                "Uttara Kannada (Karwar)",
                "Vijayapura (Bijapur)",
                "Yadgir"};
    
    String Kerala[]={"Alappuzha",
                "Ernakulam",
                "Idukki",
                "Kannur",
                "Kasaragod",
                "Kollam",
                "Kottayam",
                "Kozhikode",
                "Malappuram",
                "Palakkad",
                "Pathanamthitta",
                "Thiruvananthapuram",
                "Thrissur",
                "Wayanad"};
    
    String LakshadweepUT[]={"Agatti",
                "Amini",
                "Androth",
                "Bithra",
                "Chethlath",
                "Kavaratti",
                "Kadmath",
                "Kalpeni",
                "Kilthan",
                "Minicoy"};
    
    String MadhyaPradesh[]={"Agar Malwa",
                "Alirajpur",
                "Anuppur",
                "Ashoknagar",
                "Balaghat",
                "Barwani",
                "Betul",
                "Bhind",
                "Bhopal",
                "Burhanpur",
                "Chhatarpur",
                "Chhindwara",
                "Damoh",
                "Datia",
                "Dewas",
                "Dhar",
                "Dindori",
                "Guna",
                "Gwalior",
                "Harda",
                "Hoshangabad",
                "Indore",
                "Jabalpur",
                "Jhabua",
                "Katni",
                "Khandwa",
                "Khargone",
                "Mandla",
                "Mandsaur",
                "Morena",
                "Narsinghpur",
                "Neemuch",
                "Panna",
                "Raisen",
                "Rajgarh",
                "Ratlam",
                "Rewa",
                "Sagar",
                "Satna",
                "Sehore",
                "Seoni",
                "Shahdol",
                "Shajapur",
                "Sheopur",
                "Shivpuri",
                "Sidhi",
                "Singrauli",
                "Tikamgarh",
                "Ujjain",
                "Umaria",
                "Vidisha"};
    
    String Maharashtra[]={"Ahmednagar",
                "Akola",
                "Amravati",
                "Aurangabad",
                "Beed",
                "Bhandara",
                "Buldhana",
                "Chandrapur",
                "Dhule",
                "Gadchiroli",
                "Gondia",
                "Hingoli",
                "Jalgaon",
                "Jalna",
                "Kolhapur",
                "Latur",
                "Mumbai City",
                "Mumbai Suburban",
                "Nagpur",
                "Nanded",
                "Nandurbar",
                "Nashik",
                "Osmanabad",
                "Palghar",
                "Parbhani",
                "Pune",
                "Raigad",
                "Ratnagiri",
                "Sangli",
                "Satara",
                "Sindhudurg",
                "Solapur",
                "Thane",
                "Wardha",
                "Washim",
                "Yavatmal"};
    
    String Manipur[]={"Bishnupur",
                "Chandel",
                "Churachandpur",
                "Imphal East",
                "Imphal West",
                "Jiribam",
                "Kakching",
                "Kamjong",
                "Kangpokpi",
                "Noney",
                "Pherzawl",
                "Senapati",
                "Tamenglong",
                "Tengnoupal",
                "Thoubal",
                "Ukhrul"};
    
    String Meghalaya[]={"East Garo Hills",
                "East Jaintia Hills",
                "East Khasi Hills",
                "North Garo Hills",
                "Ri Bhoi",
                "South Garo Hills",
                "South West Garo Hills ",
                "South West Khasi Hills",
                "West Garo Hills",
                "West Jaintia Hills",
                "West Khasi Hills"};

    String Mizoram[]={"Aizawl",
                "Champhai",
                "Kolasib",
                "Lawngtlai",
                "Lunglei",
                "Mamit",
                "Saiha",
                "Serchhip"};
    
    String Nagaland[]={"Dimapur",
                "Kiphire",
                "Kohima",
                "Longleng",
                "Mokokchung",
                "Mon",
                "Peren",
                "Phek",
                "Tuensang",
                "Wokha",
                "Zunheboto"};
    
    String Odisha[]={"Angul",
                "Balangir",
                "Balasore",
                "Bargarh",
                "Bhadrak",
                "Boudh",
                "Cuttack",
                "Deogarh",
                "Dhenkanal",
                "Gajapati",
                "Ganjam",
                "Jagatsinghapur",
                "Jajpur",
                "Jharsuguda",
                "Kalahandi",
                "Kandhamal",
                "Kendrapara",
                "Kendujhar (Keonjhar)",
                "Khordha",
                "Koraput",
                "Malkangiri",
                "Mayurbhanj",
                "Nabarangpur",
                "Nayagarh",
                "Nuapada",
                "Puri",
                "Rayagada",
                "Sambalpur",
                "Sonepur",
                "Sundargarh"};
    
    String PuducherryUT[]={"Karaikal",
                "Mahe",
                "Pondicherry",
                "Yanam"};
    
    String Punjab[]={"Amritsar",
                "Barnala",
                "Bathinda",
                "Faridkot",
                "Fatehgarh Sahib",
                "Fazilka",
                "Ferozepur",
                "Gurdaspur",
                "Hoshiarpur",
                "Jalandhar",
                "Kapurthala",
                "Ludhiana",
                "Mansa",
                "Moga",
                "Muktsar",
                "Nawanshahr (Shahid Bhagat Singh Nagar)",
                "Pathankot",
                "Patiala",
                "Rupnagar",
                "Sahibzada Ajit Singh Nagar (Mohali)",
                "Sangrur",
                "Tarn Taran"};
    
    String Rajasthan[]={"Ajmer",
                "Alwar",
                "Banswara",
                "Baran",
                "Barmer",
                "Bharatpur",
                "Bhilwara",
                "Bikaner",
                "Bundi",
                "Chittorgarh",
                "Churu",
                "Dausa",
                "Dholpur",
                "Dungarpur",
                "Hanumangarh",
                "Jaipur",
                "Jaisalmer",
                "Jalore",
                "Jhalawar",
                "Jhunjhunu",
                "Jodhpur",
                "Karauli",
                "Kota",
                "Nagaur",
                "Pali",
                "Pratapgarh",
                "Rajsamand",
                "Sawai Madhopur",
                "Sikar",
                "Sirohi",
                "Sri Ganganagar",
                "Tonk",
                "Udaipur"};
    
    String Sikkim[]={"East Sikkim",
                "North Sikkim",
                "South Sikkim",
                "West Sikkim"};
    
    String TamilNadu[]={"Ariyalur",
                "Chennai",
                "Coimbatore",
                "Cuddalore",
                "Dharmapuri",
                "Dindigul",
                "Erode",
                "Kanchipuram",
                "Kanyakumari",
                "Karur",
                "Krishnagiri",
                "Madurai",
                "Nagapattinam",
                "Namakkal",
                "Nilgiris",
                "Perambalur",
                "Pudukkottai",
                "Ramanathapuram",
                "Salem",
                "Sivaganga",
                "Thanjavur",
                "Theni",
                "Thoothukudi (Tuticorin)",
                "Tiruchirappalli",
                "Tirunelveli",
                "Tiruppur",
                "Tiruvallur",
                "Tiruvannamalai",
                "Tiruvarur",
                "Vellore",
                "Viluppuram",
                "Virudhunagar"};
    
    String Telangana[]={"Adilabad",
                "Bhadradri Kothagudem",
                "Hyderabad",
                "Jagtial",
                "Jangaon",
                "Jayashankar Bhoopalpally",
                "Jogulamba Gadwal",
                "Kamareddy",
                "Karimnagar",
                "Khammam",
                "Komaram Bheem Asifabad",
                "Mahabubabad",
                "Mahabubnagar",
                "Mancherial",
                "Medak",
                "Medchal",
                "Nagarkurnool",
                "Nalgonda",
                "Nirmal",
                "Nizamabad",
                "Peddapalli",
                "Rajanna Sircilla",
                "Rangareddy",
                "Sangareddy",
                "Siddipet",
                "Suryapet",
                "Vikarabad",
                "Wanaparthy",
                "Warangal (Rural)",
                "Warangal (Urban)",
                "Yadadri Bhuvanagiri"};
    
    String Tripura[]={"Dhalai",
                "Gomati",
                "Khowai",
                "North Tripura",
                "Sepahijala",
                "South Tripura",
                "Unakoti",
                "West Tripura"};
    
    String Uttarakhand[]={"Almora",
                "Bageshwar",
                "Chamoli",
                "Champawat",
                "Dehradun",
                "Haridwar",
                "Nainital",
                "Pauri Garhwal",
                "Pithoragarh",
                "Rudraprayag",
                "Tehri Garhwal",
                "Udham Singh Nagar",
                "Uttarkashi"};
    
    String UttarPradesh[]={"Agra",
                "Aligarh",
                "Allahabad",
                "Ambedkar Nagar",
                "Amethi (Chatrapati Sahuji Mahraj Nagar)",
                "Amroha (J.P. Nagar)",
                "Auraiya",
                "Azamgarh",
                "Baghpat",
                "Bahraich",
                "Ballia",
                "Balrampur",
                "Banda",
                "Barabanki",
                "Bareilly",
                "Basti",
                "Bhadohi",
                "Bijnor",
                "Budaun",
                "Bulandshahr",
                "Chandauli",
                "Chitrakoot",
                "Deoria",
                "Etah",
                "Etawah",
                "Faizabad",
                "Farrukhabad",
                "Fatehpur",
                "Firozabad",
                "Gautam Buddha Nagar",
                "Ghaziabad",
                "Ghazipur",
                "Gonda",
                "Gorakhpur",
                "Hamirpur",
                "Hapur (Panchsheel Nagar)",
                "Hardoi",
                "Hathras",
                "Jalaun",
                "Jaunpur",
                "Jhansi",
                "Kannauj",
                "Kanpur Dehat",
                "Kanpur Nagar",
                "Kanshiram Nagar (Kasganj)",
                "Kaushambi",
                "Kushinagar (Padrauna)",
                "Lakhimpur - Kheri",
                "Lalitpur",
                "Lucknow",
                "Maharajganj",
                "Mahoba",
                "Mainpuri",
                "Mathura",
                "Mau",
                "Meerut",
                "Mirzapur",
                "Moradabad",
                "Muzaffarnagar",
                "Pilibhit",
                "Pratapgarh",
                "RaeBareli",
                "Rampur",
                "Saharanpur",
                "Sambhal (Bhim Nagar)",
                "Sant Kabir Nagar",
                "Shahjahanpur",
                "Shamali (Prabuddh Nagar)",
                "Shravasti",
                "Siddharth Nagar",
                "Sitapur",
                "Sonbhadra",
                "Sultanpur",
                "Unnao",
                "Varanasi"};
    
    String WestBengal[]={"Alipurduar",
                "Bankura",
                "Birbhum",
                "Burdwan (Bardhaman)",
                "Cooch Behar",
                "Dakshin Dinajpur (South Dinajpur)",
                "Darjeeling",
                "Hooghly",
                "Howrah",
                "Jalpaiguri",
                "Kalimpong",
                "Kolkata",
                "Malda",
                "Murshidabad",
                "Nadia",
                "North 24 Parganas",
                "Paschim Medinipur (West Medinipur)",
                "Purba Medinipur (East Medinipur)",
                "Purulia",
                "South 24 Parganas",
                "Uttar Dinajpur (North Dinajpur)"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        presentStateNameComboBox.getItems().addAll(indianStates);
        permanentStateNameComboBox.getItems().addAll(indianStates);
        
    }

    @FXML
    private void presentStateNameChange(ActionEvent event) {
        String stateName=presentStateNameComboBox.getSelectionModel().getSelectedItem();
        switch (stateName)
        {
            case "Andaman and Nicobar":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(AndamanandNicobar);
                
                break;
            case "Arunachal Pradesh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(ArunachalPradesh);
                break;
            case "Assam":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Assam);
                break;
            case "Bihar":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Bihar);
                break;
            case "Chattisgarh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Chhattisgarh);
                break;
            case "Chandigarh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Chandigarh);
                break;
            case "Dadra and Nagar Haveli":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(DadraandNagarHaveli);
                break;
            case "Daman and Diu":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(DamanandDiu);
                break;
            case "Delhi (NCT)":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(DelhiNCT);
                break;
            case "Goa":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Goa);
                break;
            case "Gujrat":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Gujarat);
                break;
            case "Haryana":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Haryana);
                break;
            case "Himachal Pradesh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(HimachalPradesh);
                break;
            case "Jammu and Kashmir":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(JammuandKashmir);
                break;
            case "Jharkhand":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Jharkhand);
                break;
            case "Karnataka":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Karnataka);
                break;
            case "Kerala":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Kerala);
                break;
            case "Lakshadweep UT":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(LakshadweepUT);
                break;
            case "Madhya Pradesh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(MadhyaPradesh);
                break;
            case "Maharashtra":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Maharashtra);
                break;
            case "Manipur":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Manipur);
                break;
            case "Meghalaya":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Meghalaya);
                break;
            case "Mizoram":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Mizoram);
                break;
            case "Nagaland":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Nagaland);
                break;
            case "Odisha":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Odisha);
                break;
            case "Punjab":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Punjab);
                break;
            case "Puducherry UT":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(PuducherryUT);
                break;
            case "Rajasthan":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Rajasthan);
                break;
            case "Sikkim":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Sikkim);
                break;
            case "Tamil Nadu":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(TamilNadu);
                break;
            case "Telangana":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Telangana);
                break;
            case "Tripura":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Tripura);
                break;
            case "Uttar Pradesh":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(UttarPradesh);
                break;
            case "Uttrakhand":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(Uttarakhand);
                break;
            case "West Bengal":
                presentDistrictNameComboBox.getItems().clear();
                presentDistrictNameComboBox.getItems().addAll(WestBengal);
                break;

            default:
                JOptionPane.showMessageDialog(null,"):");
        }
    }

    @FXML
    private void permanentStateNameChange(ActionEvent event) {
        String stateName=permanentStateNameComboBox.getSelectionModel().getSelectedItem();
        switch (stateName)
        {
            case "Andaman and Nicobar":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(AndamanandNicobar);
                
                break;
            case "Arunachal Pradesh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(ArunachalPradesh);
                break;
            case "Assam":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Assam);
                break;
            case "Bihar":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Bihar);
                break;
            case "Chattisgarh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Chhattisgarh);
                break;
            case "Chandigarh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Chandigarh);
                break;
            case "Dadra and Nagar Haveli":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(DadraandNagarHaveli);
                break;
            case "Daman and Diu":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(DamanandDiu);
                break;
            case "Delhi (NCT)":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(DelhiNCT);
                break;
            case "Goa":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Goa);
                break;
            case "Gujrat":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Gujarat);
                break;
            case "Haryana":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Haryana);
                break;
            case "Himachal Pradesh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(HimachalPradesh);
                break;
            case "Jammu and Kashmir":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(JammuandKashmir);
                break;
            case "Jharkhand":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Jharkhand);
                break;
            case "Karnataka":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Karnataka);
                break;
            case "Kerala":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Kerala);
                break;
            case "Lakshadweep UT":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(LakshadweepUT);
                break;
            case "Madhya Pradesh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(MadhyaPradesh);
                break;
            case "Maharashtra":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Maharashtra);
                break;
            case "Manipur":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Manipur);
                break;
            case "Meghalaya":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Meghalaya);
                break;
            case "Mizoram":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Mizoram);
                break;
            case "Nagaland":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Nagaland);
                break;
            case "Odisha":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Odisha);
                break;
            case "Punjab":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Punjab);
                break;
            case "Puducherry UT":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(PuducherryUT);
                break;
            case "Rajasthan":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Rajasthan);
                break;
            case "Sikkim":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Sikkim);
                break;
            case "Tamil Nadu":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(TamilNadu);
                break;
            case "Telangana":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Telangana);
                break;
            case "Tripura":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Tripura);
                break;
            case "Uttar Pradesh":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(UttarPradesh);
                break;
            case "Uttrakhand":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(Uttarakhand);
                break;
            case "West Bengal":
                permanentDistrictNameComboBox.getItems().clear();
                permanentDistrictNameComboBox.getItems().addAll(WestBengal);
                break;

            default:
                JOptionPane.showMessageDialog(null,"):");
        }
    }

    
    boolean validateAllFieldsForEmpty(){
        if(presentAddressLine1TF.getText().isEmpty()){
            Notifications.create().title("Please Enter Address Line 1").showError();
            presentAddressLine1TF.requestFocus();
        }else{
            if(presentCityNameTF.getText().isEmpty()){
                Notifications.create().title("Please Enter City Name").showError();
            presentCityNameTF.requestFocus();
            }else{
                if(presentStateNameComboBox.getSelectionModel().isEmpty()){
                    Notifications.create().title("Please Select State").showError();
                    presentStateNameComboBox.requestFocus();
                }else{
                    if(presentDistrictNameComboBox.getItems().isEmpty()){
                        Notifications.create().title("Please Select District").showError();
                        presentDistrictNameComboBox.requestFocus();
                    }else{
                        if(presentPinCodeTF.getText().isEmpty()){
                            Notifications.create().title("Please Enter PIN Code").showError();
                            presentPinCodeTF.requestFocus();
                        }else{
                            if(permanentAddressLine1TF.getText().isEmpty()){
                                Notifications.create().title("Please Enter Address Line 1").showError();
                                permanentAddressLine1TF.requestFocus();
                            }else{
                                if(permanentCityNameTF.getText().isEmpty()){
                                    Notifications.create().title("Please Enter City Name").showError();
                                    permanentCityNameTF.requestFocus();
                                }else{
                                    if(permanentStateNameComboBox.getSelectionModel().isEmpty()){
                                        Notifications.create().title("Please Select State").showError();
                                        permanentStateNameComboBox.requestFocus();
                                    }else{
                                        if(permanentDistrictNameComboBox.getItems().isEmpty()){
                                            Notifications.create().title("Please Select District").showError();
                                            permanentDistrictNameComboBox.requestFocus();
                                        }else{
                                            if(permanentPinCodeTF.getText().isEmpty()){
                                                Notifications.create().title("Please Enter PIN Code").showError();
                                                permanentPinCodeTF.requestFocus();
                                            }else{
                                                  return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        
        }
        return false;
    }
    
    
    boolean validateAllFieldsForWrongEntry(){
        if(presentAddressLine1TF.getText().length()<25){
            if(presentCityNameTF.getText().length()<20){
                if(presentPinCodeTF.getText().length()==6 && presentPinCodeTF.getText().matches("[0-9]+")){
                    if(permanentAddressLine1TF.getText().length()<25){
                        if(permanentCityNameTF.getText().length()<20){
                            if(permanentPinCodeTF.getText().length()==6 && permanentPinCodeTF.getText().matches("[0-9]+")){
                                return true;
                            }else{
                                Notifications.create().title("Please a valid PIN Code").showError();
                                permanentPinCodeTF.requestFocus();
                            }
                        }else{
                            Notifications.create().title("Please a valid City Name").showError();
                            permanentCityNameTF.requestFocus();
                        }
                    }else{
                        Notifications.create().title("Address Line 1 is too long").showError();
                        permanentAddressLine1TF.requestFocus();
                    }
                }else{
                    Notifications.create().title("Please Enter a valid PIN Code").showError();
                            presentPinCodeTF.requestFocus();
                }
            }else{
                Notifications.create().title("Please a valid City Name").showError();
                            presentCityNameTF.requestFocus();
            }
        }else{
            Notifications.create().title("Address Line 1 is too long").showError();
            presentAddressLine1TF.requestFocus();
        }
        
        
        return false;
    }
    
    StudentAddressDetails getDataFromPage2AndSendDataToMainBoard(){
        StudentAddressDetails studentAddressDetails=new StudentAddressDetails();
        
        String presentAddressLine1=presentAddressLine1TF.getText();
        String presentCityName=presentCityNameTF.getText();
        String presentStateName=presentStateNameComboBox.getSelectionModel().getSelectedItem();
        String presentDistrictName=presentDistrictNameComboBox.getSelectionModel().getSelectedItem();
        String presentPinCode=presentPinCodeTF.getText();
        
        String permanentAddressLine1=permanentAddressLine1TF.getText();
        String permanentCityName=permanentCityNameTF.getText();
        String permanentStateName=permanentStateNameComboBox.getSelectionModel().getSelectedItem();
        String permanentDistrictName=permanentDistrictNameComboBox.getSelectionModel().getSelectedItem();
        String permanentPinCode=permanentPinCodeTF.getText();
        
        studentAddressDetails.setPresentAddressLine1(presentAddressLine1);
        studentAddressDetails.setPresentCityName(presentCityName);
        studentAddressDetails.setPresentStateName(presentStateName);
        studentAddressDetails.setPresentDistrictName(presentDistrictName);
        studentAddressDetails.setPresentPinCode(presentPinCode);
        
        studentAddressDetails.setPermanentAddressLine1(permanentAddressLine1);
        studentAddressDetails.setPermanentCityName(permanentCityName);
        studentAddressDetails.setPermanentStateName(permanentStateName);
        studentAddressDetails.setPermanentDistrictName(permanentDistrictName);
        studentAddressDetails.setPermanentPinCode(permanentPinCode);
        
        return studentAddressDetails;
    }
    
    
    void getExistingDataFromMainBoardAndSetToPage2(StudentAddressDetails studentAddressDetails){
        if(studentAddressDetails!=null){
            presentAddressLine1TF.setText(studentAddressDetails.getPresentAddressLine1());
            presentCityNameTF.setText(studentAddressDetails.getPresentCityName());
            presentStateNameComboBox.setValue(studentAddressDetails.getPresentStateName());
            presentDistrictNameComboBox.setValue(studentAddressDetails.getPresentDistrictName());
            presentPinCodeTF.setText(studentAddressDetails.getPresentPinCode());
    
            permanentAddressLine1TF.setText(studentAddressDetails.getPermanentAddressLine1());
            permanentCityNameTF.setText(studentAddressDetails.getPermanentCityName());
            permanentStateNameComboBox.setValue(studentAddressDetails.getPermanentStateName());
            permanentDistrictNameComboBox.setValue(studentAddressDetails.getPermanentDistrictName());
            permanentPinCodeTF.setText(studentAddressDetails.getPermanentPinCode());
        }
     }
}

