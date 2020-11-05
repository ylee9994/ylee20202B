package com.ylee.a06xmljson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    String xmldata = "<current>\n" +
            "<city id=\"1835848\" name=\"Seoul\">\n" +
            "<coord lon=\"126.98\" lat=\"37.57\"/>\n" +
            "<country>KR</country>\n" +
            "<timezone>32400</timezone>\n" +
            "<sun rise=\"2019-09-25T21:22:31\" set=\"2019-09-26T09:24:48\"/>\n" +
            "</city>\n" +
            "<temperature value=\"299.78\" min=\"298.15\" max=\"301.15\" unit=\"kelvin\"/>\n" +
            "<humidity value=\"54\" unit=\"%\"/>\n" +
            "<pressure value=\"1023\" unit=\"hPa\"/>\n" +
            "<wind>\n" +
            "<speed value=\"2.1\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<gusts/>\n" +
            "<direction value=\"330\" code=\"NNW\" name=\"North-northwest\"/>\n" +
            "</wind>\n" +
            "<clouds value=\"20\" name=\"few clouds\"/>\n" +
            "<visibility value=\"10000\"/>\n" +
            "<precipitation mode=\"no\"/>\n" +
            "<weather number=\"721\" value=\"haze\" icon=\"50d\"/>\n" +
            "<lastupdate value=\"2019-09-26T06:30:27\"/>\n" +
            "</current>";
    String xmlforecast = "<weatherdata>\n" +
            "<location>\n" +
            "<name>Seoul</name>\n" +
            "<type/>\n" +
            "<country>KR</country>\n" +
            "<timezone>32400</timezone>\n" +
            "<location altitude=\"0\" latitude=\"37.5667\" longitude=\"126.9783\" geobase=\"geonames\" geobaseid=\"1835848\"/>\n" +
            "</location>\n" +
            "<credit/>\n" +
            "<meta>\n" +
            "<lastupdate/>\n" +
            "<calctime>0.0075</calctime>\n" +
            "<nextupdate/>\n" +
            "</meta>\n" +
            "<sun rise=\"2019-09-25T21:22:32\" set=\"2019-09-26T09:24:48\"/>\n" +
            "<forecast>\n" +
            "<time from=\"2019-09-26T09:00:00\" to=\"2019-09-26T12:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"100.554\" code=\"E\" name=\"East\"/>\n" +
            "<windSpeed mps=\"0.64\" unit=\"m/s\" name=\"Calm\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.63\" min=\"22.55\" max=\"22.63\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1024.27\"/>\n" +
            "<humidity value=\"76\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-26T12:00:00\" to=\"2019-09-26T15:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"115.31\" code=\"ESE\" name=\"East-southeast\"/>\n" +
            "<windSpeed mps=\"1.57\" unit=\"m/s\" name=\"\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.61\" min=\"22.55\" max=\"22.61\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1023.67\"/>\n" +
            "<humidity value=\"73\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-26T15:00:00\" to=\"2019-09-26T18:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"148.824\" code=\"SSE\" name=\"South-southeast\"/>\n" +
            "<windSpeed mps=\"3.71\" unit=\"m/s\" name=\"Gentle Breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.28\" min=\"22.24\" max=\"22.28\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1023.76\"/>\n" +
            "<humidity value=\"61\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-26T18:00:00\" to=\"2019-09-26T21:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"155.161\" code=\"SSE\" name=\"South-southeast\"/>\n" +
            "<windSpeed mps=\"2.95\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.89\" min=\"21.87\" max=\"21.89\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1023.91\"/>\n" +
            "<humidity value=\"63\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-26T21:00:00\" to=\"2019-09-27T00:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"114.008\" code=\"ESE\" name=\"East-southeast\"/>\n" +
            "<windSpeed mps=\"1.65\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.71\" min=\"21.71\" max=\"21.71\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1023.89\"/>\n" +
            "<humidity value=\"64\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T00:00:00\" to=\"2019-09-27T03:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"215.362\" code=\"SW\" name=\"Southwest\"/>\n" +
            "<windSpeed mps=\"0.38\" unit=\"m/s\" name=\"Calm\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.45\" min=\"22.45\" max=\"22.45\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1022.84\"/>\n" +
            "<humidity value=\"65\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T03:00:00\" to=\"2019-09-27T06:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"292.324\" code=\"WNW\" name=\"West-northwest\"/>\n" +
            "<windSpeed mps=\"3.38\" unit=\"m/s\" name=\"\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.23\" min=\"22.23\" max=\"22.23\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1021.1\"/>\n" +
            "<humidity value=\"67\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T06:00:00\" to=\"2019-09-27T09:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"308.487\" code=\"NW\" name=\"Northwest\"/>\n" +
            "<windSpeed mps=\"2.08\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.79\" min=\"22.79\" max=\"22.79\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1020.9\"/>\n" +
            "<humidity value=\"70\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T09:00:00\" to=\"2019-09-27T12:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"318.502\" code=\"NW\" name=\"Northwest\"/>\n" +
            "<windSpeed mps=\"3.37\" unit=\"m/s\" name=\"\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.18\" min=\"22.18\" max=\"22.18\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1021.35\"/>\n" +
            "<humidity value=\"70\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T12:00:00\" to=\"2019-09-27T15:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"316.445\" code=\"NW\" name=\"Northwest\"/>\n" +
            "<windSpeed mps=\"3.81\" unit=\"m/s\" name=\"Gentle Breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.92\" min=\"21.92\" max=\"21.92\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1020.61\"/>\n" +
            "<humidity value=\"68\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T15:00:00\" to=\"2019-09-27T18:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"349.958\" code=\"\" name=\"\"/>\n" +
            "<windSpeed mps=\"2.73\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.75\" min=\"21.75\" max=\"21.75\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1020\"/>\n" +
            "<humidity value=\"66\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"100\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T18:00:00\" to=\"2019-09-27T21:00:00\">\n" +
            "<symbol number=\"804\" name=\"overcast clouds\" var=\"04n\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"9.401\" code=\"N\" name=\"North\"/>\n" +
            "<windSpeed mps=\"2.45\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.32\" min=\"21.32\" max=\"21.32\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1020.16\"/>\n" +
            "<humidity value=\"66\" unit=\"%\"/>\n" +
            "<clouds value=\"overcast clouds\" all=\"86\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-27T21:00:00\" to=\"2019-09-28T00:00:00\">\n" +
            "<symbol number=\"802\" name=\"scattered clouds\" var=\"03d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"17.321\" code=\"NNE\" name=\"North-northeast\"/>\n" +
            "<windSpeed mps=\"1.76\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"21.2\" min=\"21.2\" max=\"21.2\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1020.1\"/>\n" +
            "<humidity value=\"67\" unit=\"%\"/>\n" +
            "<clouds value=\"scattered clouds\" all=\"43\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-28T00:00:00\" to=\"2019-09-28T03:00:00\">\n" +
            "<symbol number=\"800\" name=\"clear sky\" var=\"01d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"269.285\" code=\"W\" name=\"West\"/>\n" +
            "<windSpeed mps=\"2.48\" unit=\"m/s\" name=\"Light breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22\" min=\"22\" max=\"22\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1019.45\"/>\n" +
            "<humidity value=\"64\" unit=\"%\"/>\n" +
            "<clouds value=\"clear sky\" all=\"0\" unit=\"%\"/>\n" +
            "</time>\n" +
            "<time from=\"2019-09-28T03:00:00\" to=\"2019-09-28T06:00:00\">\n" +
            "<symbol number=\"800\" name=\"clear sky\" var=\"01d\"/>\n" +
            "<precipitation/>\n" +
            "<windDirection deg=\"278.114\" code=\"W\" name=\"West\"/>\n" +
            "<windSpeed mps=\"4.54\" unit=\"m/s\" name=\"Gentle Breeze\"/>\n" +
            "<temperature unit=\"celsius\" value=\"22.21\" min=\"22.21\" max=\"22.21\"/>\n" +
            "<pressure unit=\"hPa\" value=\"1017.02\"/>\n" +
            "<humidity value=\"69\" unit=\"%\"/>\n" +
            "<clouds value=\"clear sky\" all=\"0\" unit=\"%\"/>\n" +
            "</time>\n" +
            "</forecast>\n" +
            "</weatherdata>";
    String xmlbooks = "<?xml version=\"1.0\"?>\n" +
            "<catalog>\n" +
            "   <book id=\"bk101\">\n" +
            "      <author>Gambardella, Matthew</author>\n" +
            "      <title>XML Developer's Guide</title>\n" +
            "      <genre>Computer</genre>\n" +
            "      <price>44.95</price>\n" +
            "      <publish_date>2000-10-01</publish_date>\n" +
            "      <description>An in-depth look at creating applications \n" +
            "      with XML.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk102\">\n" +
            "      <author>Ralls, Kim</author>\n" +
            "      <title>Midnight Rain</title>\n" +
            "      <genre>Fantasy</genre>\n" +
            "      <price>5.95</price>\n" +
            "      <publish_date>2000-12-16</publish_date>\n" +
            "      <description>A former architect battles corporate zombies, \n" +
            "      an evil sorceress, and her own childhood to become queen \n" +
            "      of the world.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk103\">\n" +
            "      <author>Corets, Eva</author>\n" +
            "      <title>Maeve Ascendant</title>\n" +
            "      <genre>Fantasy</genre>\n" +
            "      <price>5.95</price>\n" +
            "      <publish_date>2000-11-17</publish_date>\n" +
            "      <description>After the collapse of a nanotechnology \n" +
            "      society in England, the young survivors lay the \n" +
            "      foundation for a new society.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk104\">\n" +
            "      <author>Corets, Eva</author>\n" +
            "      <title>Oberon's Legacy</title>\n" +
            "      <genre>Fantasy</genre>\n" +
            "      <price>5.95</price>\n" +
            "      <publish_date>2001-03-10</publish_date>\n" +
            "      <description>In post-apocalypse England, the mysterious \n" +
            "      agent known only as Oberon helps to create a new life \n" +
            "      for the inhabitants of London. Sequel to Maeve \n" +
            "      Ascendant.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk105\">\n" +
            "      <author>Corets, Eva</author>\n" +
            "      <title>The Sundered Grail</title>\n" +
            "      <genre>Fantasy</genre>\n" +
            "      <price>5.95</price>\n" +
            "      <publish_date>2001-09-10</publish_date>\n" +
            "      <description>The two daughters of Maeve, half-sisters, \n" +
            "      battle one another for control of England. Sequel to \n" +
            "      Oberon's Legacy.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk106\">\n" +
            "      <author>Randall, Cynthia</author>\n" +
            "      <title>Lover Birds</title>\n" +
            "      <genre>Romance</genre>\n" +
            "      <price>4.95</price>\n" +
            "      <publish_date>2000-09-02</publish_date>\n" +
            "      <description>When Carla meets Paul at an ornithology \n" +
            "      conference, tempers fly as feathers get ruffled.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk107\">\n" +
            "      <author>Thurman, Paula</author>\n" +
            "      <title>Splish Splash</title>\n" +
            "      <genre>Romance</genre>\n" +
            "      <price>4.95</price>\n" +
            "      <publish_date>2000-11-02</publish_date>\n" +
            "      <description>A deep sea diver finds true love twenty \n" +
            "      thousand leagues beneath the sea.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk108\">\n" +
            "      <author>Knorr, Stefan</author>\n" +
            "      <title>Creepy Crawlies</title>\n" +
            "      <genre>Horror</genre>\n" +
            "      <price>4.95</price>\n" +
            "      <publish_date>2000-12-06</publish_date>\n" +
            "      <description>An anthology of horror stories about roaches,\n" +
            "      centipedes, scorpions  and other insects.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk109\">\n" +
            "      <author>Kress, Peter</author>\n" +
            "      <title>Paradox Lost</title>\n" +
            "      <genre>Science Fiction</genre>\n" +
            "      <price>6.95</price>\n" +
            "      <publish_date>2000-11-02</publish_date>\n" +
            "      <description>After an inadvertant trip through a Heisenberg\n" +
            "      Uncertainty Device, James Salway discovers the problems \n" +
            "      of being quantum.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk110\">\n" +
            "      <author>O'Brien, Tim</author>\n" +
            "      <title>Microsoft .NET: The Programming Bible</title>\n" +
            "      <genre>Computer</genre>\n" +
            "      <price>36.95</price>\n" +
            "      <publish_date>2000-12-09</publish_date>\n" +
            "      <description>Microsoft's .NET initiative is explored in \n" +
            "      detail in this deep programmer's reference.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk111\">\n" +
            "      <author>O'Brien, Tim</author>\n" +
            "      <title>MSXML3: A Comprehensive Guide</title>\n" +
            "      <genre>Computer</genre>\n" +
            "      <price>36.95</price>\n" +
            "      <publish_date>2000-12-01</publish_date>\n" +
            "      <description>The Microsoft MSXML3 parser is covered in \n" +
            "      detail, with attention to XML DOM interfaces, XSLT processing, \n" +
            "      SAX and more.</description>\n" +
            "   </book>\n" +
            "   <book id=\"bk112\">\n" +
            "      <author>Galos, Mike</author>\n" +
            "      <title>Visual Studio 7: A Comprehensive Guide</title>\n" +
            "      <genre>Computer</genre>\n" +
            "      <price>49.95</price>\n" +
            "      <publish_date>2001-04-16</publish_date>\n" +
            "      <description>Microsoft Visual Studio 7 is explored in depth,\n" +
            "      looking at how Visual Basic, Visual C++, C#, and ASP+ are \n" +
            "      integrated into a comprehensive development \n" +
            "      environment.</description>\n" +
            "   </book>\n" +
            "</catalog>";

    String jsondata = "{\"coord\":{\"lon\":126.98,\"lat\":37.57},\"weather\":[{\"id\":721,\"main\":\"Haze\",\"description\":\"haze\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":299.78,\"pressure\":1023,\"humidity\":54,\"temp_min\":298.15,\"temp_max\":301.15},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":330},\"clouds\":{\"all\":20},\"dt\":1569479121,\"sys\":{\"type\":1,\"id\":5509,\"message\":0.0062,\"country\":\"KR\",\"sunrise\":1569446551,\"sunset\":1569489888},\"timezone\":32400,\"id\":1835848,\"name\":\"Seoul\",\"cod\":200}";
    String jsonforecast="{\"cod\":\"200\",\"message\":0.0075,\"cnt\":15,\"list\":[{\"dt\":1569499200,\"main\":{\"temp\":22.63,\"temp_min\":22.55,\"temp_max\":22.63,\"pressure\":1024.27,\"sea_level\":1024.27,\"grnd_level\":1023.03,\"humidity\":76,\"temp_kf\":0.08},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.64,\"deg\":100.554},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 12:00:00\"},{\"dt\":1569510000,\"main\":{\"temp\":22.61,\"temp_min\":22.55,\"temp_max\":22.61,\"pressure\":1023.67,\"sea_level\":1023.67,\"grnd_level\":1022.25,\"humidity\":73,\"temp_kf\":0.06},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.57,\"deg\":115.31},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 15:00:00\"},{\"dt\":1569520800,\"main\":{\"temp\":22.28,\"temp_min\":22.24,\"temp_max\":22.28,\"pressure\":1023.76,\"sea_level\":1023.76,\"grnd_level\":1022.46,\"humidity\":61,\"temp_kf\":0.04},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.71,\"deg\":148.824},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 18:00:00\"},{\"dt\":1569531600,\"main\":{\"temp\":21.89,\"temp_min\":21.87,\"temp_max\":21.89,\"pressure\":1023.91,\"sea_level\":1023.91,\"grnd_level\":1022.58,\"humidity\":63,\"temp_kf\":0.02},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.95,\"deg\":155.161},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 21:00:00\"},{\"dt\":1569542400,\"main\":{\"temp\":21.71,\"temp_min\":21.71,\"temp_max\":21.71,\"pressure\":1023.89,\"sea_level\":1023.89,\"grnd_level\":1022.77,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.65,\"deg\":114.008},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 00:00:00\"},{\"dt\":1569553200,\"main\":{\"temp\":22.45,\"temp_min\":22.45,\"temp_max\":22.45,\"pressure\":1022.84,\"sea_level\":1022.84,\"grnd_level\":1021.8,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.38,\"deg\":215.362},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 03:00:00\"},{\"dt\":1569564000,\"main\":{\"temp\":22.23,\"temp_min\":22.23,\"temp_max\":22.23,\"pressure\":1021.1,\"sea_level\":1021.1,\"grnd_level\":1020.2,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.38,\"deg\":292.324},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 06:00:00\"},{\"dt\":1569574800,\"main\":{\"temp\":22.79,\"temp_min\":22.79,\"temp_max\":22.79,\"pressure\":1020.9,\"sea_level\":1020.9,\"grnd_level\":1019.6,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.08,\"deg\":308.487},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 09:00:00\"},{\"dt\":1569585600,\"main\":{\"temp\":22.18,\"temp_min\":22.18,\"temp_max\":22.18,\"pressure\":1021.35,\"sea_level\":1021.35,\"grnd_level\":1019.98,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.37,\"deg\":318.502},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 12:00:00\"},{\"dt\":1569596400,\"main\":{\"temp\":21.92,\"temp_min\":21.92,\"temp_max\":21.92,\"pressure\":1020.61,\"sea_level\":1020.61,\"grnd_level\":1019.29,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.81,\"deg\":316.445},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 15:00:00\"},{\"dt\":1569607200,\"main\":{\"temp\":21.75,\"temp_min\":21.75,\"temp_max\":21.75,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1018.41,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.73,\"deg\":349.958},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 18:00:00\"},{\"dt\":1569618000,\"main\":{\"temp\":21.32,\"temp_min\":21.32,\"temp_max\":21.32,\"pressure\":1020.16,\"sea_level\":1020.16,\"grnd_level\":1018.65,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":86},\"wind\":{\"speed\":2.45,\"deg\":9.401},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 21:00:00\"},{\"dt\":1569628800,\"main\":{\"temp\":21.2,\"temp_min\":21.2,\"temp_max\":21.2,\"pressure\":1020.1,\"sea_level\":1020.1,\"grnd_level\":1018.99,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":43},\"wind\":{\"speed\":1.76,\"deg\":17.321},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 00:00:00\"},{\"dt\":1569639600,\"main\":{\"temp\":22,\"temp_min\":22,\"temp_max\":22,\"pressure\":1019.45,\"sea_level\":1019.45,\"grnd_level\":1018.72,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.48,\"deg\":269.285},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 03:00:00\"},{\"dt\":1569650400,\"main\":{\"temp\":22.21,\"temp_min\":22.21,\"temp_max\":22.21,\"pressure\":1017.02,\"sea_level\":1017.02,\"grnd_level\":1016.36,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.54,\"deg\":278.114},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 06:00:00\"}],\"city\":{\"id\":1835848,\"name\":\"Seoul\",\"coord\":{\"lat\":37.5667,\"lon\":126.9783},\"country\":\"KR\",\"population\":10349312,\"timezone\":32400,\"sunrise\":1569446552,\"sunset\":1569489888}}";

    EditText editText;
    TextView textView;
    TextView updates, country, location, temp, humidity, pressure;
    Button button;

    ArrayList<SBooks> BooksArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        updates = findViewById(R.id.updates);
        country = findViewById(R.id.country);
        location = findViewById(R.id.location);
        temp = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);
        button = findViewById(R.id.button);
        setTitle("이용희xml");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseXMLopenweather(xmldata);
                parseXMLforecast(xmlforecast);
                parseXMLbooks(xmlbooks);
            }
        });
    }

    // 2차과제
    // 1. xmlbooks 파싱
    // 2. 저자, 제목, 가격순으로 textView에 표시
    // 3. 가격 > 40$ 보다 큰 책은 뺄것
    public void parseXMLbooks(String odata){
        if(odata == null){
            textView.setText("데이터없음");
        }
        String author = null, title = null, price = null;
        Float fprice = 0.0f;
        String presult = "BOOKS\n";
        try{
            String fxml;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(odata));

            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_DOCUMENT){

                }else if(eventType == XmlPullParser.START_TAG){
                    fxml = xpp.getName();
                    if(fxml.equals("author")){
                        eventType = xpp.next();
                        if(eventType == XmlPullParser.TEXT){
                            author = xpp.getText();
                        }
                    }else if(fxml.equals("title")){
                        eventType = xpp.next();
                        if(eventType == XmlPullParser.TEXT){
                            title = xpp.getText();
                        }
                    }else if(fxml.equals("price")){
                        eventType = xpp.next();
                        if(eventType == XmlPullParser.TEXT){
                            price = xpp.getText();
                            fprice = Float.parseFloat(price);
                            SBooks abook = new SBooks(author, title, fprice);
                            BooksArray.add(abook);
                        }
                    }
                }
                eventType = xpp.next();
            }
        }catch (Exception e){
            Log.e("xml parsing", "Parsing error", e);
        }

        // 일반적인 for 문장
//        for(int i=0; i<BooksArray.size(); ++i){
//            SBooks abook = BooksArray.get(i);
//            if(abook.price <= 40.0f){
//                presult  += "저자: " + abook.author +
//                        " 제목: " + abook.title +
//                        " 가격"  + abook.price + "$" + "\n";
//            }
//        }

        Collections.sort(BooksArray);
        // for each 문으로 재프로그램
        for( SBooks abook:BooksArray){
            if(abook.price <= 40.0f){
                presult  += "저자: " + abook.author +
                        " 제목: " + abook.title +
                        " 가격"  + abook.price + "$" + "\n";
            }
        }

        textView.setText(presult);
    }

    // 1차과제
    // 1. xmlforecast 데이터 파싱, 시간, 온도, 습도만 표시
    // 2. setTitle("이용희xml");
    // 3. 에뮬레이터(AVD) 캡쳐해서 오늘 과제방 제출
    public void parseXMLforecast(String odata){
        if(odata == null){
            textView.setText("데이터없음");
        }
        String presult="날씨예보\n";
        String supdate = null, stemp = null, shumidity = null;

        try{
            String fxml;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(odata));

            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_DOCUMENT){
                    presult += "Start of XML\n";
                }else if(eventType == XmlPullParser.START_TAG){
                    fxml = xpp.getName();
                    if(fxml.equals("temperature")){
                        stemp = xpp.getAttributeValue(null, "value");
                    }else if(fxml.equals("time")){
                        supdate = xpp.getAttributeValue(null, "from");
                    }else if(fxml.equals("humidity")){
                        shumidity = xpp.getAttributeValue(null, "value");
                        presult += "시간" + supdate + " 온도:" + stemp +
                                " 습도: " + shumidity + "\n";
                    }
                }
                eventType = xpp.next();
            }
        }catch (Exception e){
            Log.e("xml parsing", "Parsing error", e);
        }
        textView.setText(presult);
    }

    public void parseXMLforecastLYH(String odata){
        if(odata == null){
            textView.setText("데이터없음");
        }
        String presult="날씨예보";
         presult = presult + "시간: 2019-09-26T09:00:00" +
                 "온도:22.6" + "습도: 29" + "\n"+
                 "시간: 2019-09-26T09:00:00" +
                 "온도:22.6" + "습도: 29" + "\n"+
        "시간: 2019-09-26T09:00:00" +
                "온도:22.6" + "습도: 29" + "\n"+
        "시간: 2019-09-26T09:00:00" +
                "온도:22.6" + "습도: 29"+ "\n";


        textView.setText(presult);
    }

    public void parseXMLopenweather(String odata){
        if(odata == null) {
            updates.setText("디폴트: 오늘");
            country.setText("디폴트: 한국");
            location.setText("디폴트: 서울");
            temp.setText("디폴트: 쾌적");
            humidity.setText("디폴트: 좋음");
            pressure.setText("디폴트: 적당");
            textView.setText(odata);
        }
        String supdats=null, scountry=null, slocation=null, stemp = null;
        String shumidity = null, spressure = null;
        String presult = "XML:";

        try{
            String fxml;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(odata));

            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_DOCUMENT){
                    presult += "Start of XML\n";
                }else if(eventType == XmlPullParser.START_TAG){
                    fxml = xpp.getName();

                    //<temperature value="20.3" min="20" max="21" unit="celsius"/>
                    if(fxml.equals("temperature")){
                        stemp = xpp.getAttributeValue(null, "value");
                    }
                    //"<humidity value=\"54\" unit=\"%\"/>\n" +
                    //"<pressure value=\"1023\" unit=\"hPa\"/>\n" +
                    else if(fxml.equals("humidity")){
                        shumidity = xpp.getAttributeValue(null, "value");
                    }else if(fxml.equals("pressure")){
                        spressure = xpp.getAttributeValue(null, "value");
                        String sunit = xpp.getAttributeValue(null, "unit");
                        spressure += " " + sunit;
                    }
                    // "<coord lon="126.98" lat="37.57"/>\n" +
                    else if(fxml.equals("coord")){
                        String slon = xpp.getAttributeValue(null, "lon");
                        String slat = xpp.getAttributeValue(null, "lat");
                        // 경도: 126.98, 위도: 37.57
                        slocation = "경도: " + slon + ", " + "위도: " + slat;
                    }
                    // <country>KR</country>
                    else if(fxml.equals("country")){
                        eventType = xpp.next();
                        if(eventType == XmlPullParser.TEXT){
                            scountry = xpp.getText();
                        }
                    }
                }
                eventType = xpp.next();
            }
        }catch (Exception e){
            Log.e("xml parsing", "Parsing error", e);
        }

        updates.setText(supdats);
        country.setText(scountry);
        location.setText(slocation);
        temp.setText(stemp);
        humidity.setText(shumidity);
        pressure.setText(spressure);
        textView.setText(presult);
    }
}
