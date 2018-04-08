package com.example.android.booklister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // ListView for main activity
    private ListView mListView;
    private BookAdapter mAdapter;

    private String jsonData = "{\n" +
            "kind: \"books#volumes\",\n" +
            "totalItems: 3742,\n" +
            "items: [\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"ti6zoAC9Ph8C\",\n" +
            "etag: \"UyZOvRcFWUg\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/ti6zoAC9Ph8C\",\n" +
            "volumeInfo: {\n" +
            "title: \"Types and Programming Languages\",\n" +
            "authors: [\n" +
            "\"Benjamin C. Pierce\"\n" +
            "],\n" +
            "publisher: \"MIT Press\",\n" +
            "publishedDate: \"2002\",\n" +
            "description: \"A comprehensive introduction to type systems and programming languages.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0262162091\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780262162098\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 623,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "averageRating: 4,\n" +
            "ratingsCount: 9,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"preview-1.0.0\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=ti6zoAC9Ph8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=ti6zoAC9Ph8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=ti6zoAC9Ph8C&printsec=frontcover&dq=programming&hl=&cd=1&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=ti6zoAC9Ph8C&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Types_and_Programming_Languages.html?hl=&id=ti6zoAC9Ph8C\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=ti6zoAC9Ph8C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"Mathematical Preliminaries - Untyped Systems - Untyped Arithmetic Expressions - An ML Implementation of Arithmetic Expressions - The Untyped Lambda-Calculus - Nameless Representation of Terms - An ML Implementation of the Lambda-Calculus - ...\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"7Uh8XGfJbEIC\",\n" +
            "etag: \"Vd+AobBdubM\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/7Uh8XGfJbEIC\",\n" +
            "volumeInfo: {\n" +
            "title: \"Concepts in Programming Languages\",\n" +
            "authors: [\n" +
            "\"John C. Mitchell\"\n" +
            "],\n" +
            "publisher: \"Cambridge University Press\",\n" +
            "publishedDate: \"2003\",\n" +
            "description: \"A comprehensive undergraduate textbook covering both theory and practical design issues, with an emphasis on object-oriented languages.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0521780985\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780521780988\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 529,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "averageRating: 3.5,\n" +
            "ratingsCount: 5,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"1.0.1.0.preview.1\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=7Uh8XGfJbEIC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=7Uh8XGfJbEIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=7Uh8XGfJbEIC&printsec=frontcover&dq=programming&hl=&cd=2&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=7Uh8XGfJbEIC&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Concepts_in_Programming_Languages.html?hl=&id=7Uh8XGfJbEIC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/Concepts_in_Programming_Languages-sample-pdf.acsm?id=7Uh8XGfJbEIC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=7Uh8XGfJbEIC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"A comprehensive undergraduate textbook covering both theory and practical design issues, with an emphasis on object-oriented languages.\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"kNZHC-ODtCcC\",\n" +
            "etag: \"twhBxMe4IPY\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/kNZHC-ODtCcC\",\n" +
            "volumeInfo: {\n" +
            "title: \"Programming In Basic\",\n" +
            "authors: [\n" +
            "\"Balagurusamy\"\n" +
            "],\n" +
            "publisher: \"Tata McGraw-Hill Education\",\n" +
            "publishedDate: \"1991\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0074600559\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780074600559\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 317,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"BASIC (Computer program language)\"\n" +
            "],\n" +
            "averageRating: 4.5,\n" +
            "ratingsCount: 2,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"0.0.1.0.preview.1\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=kNZHC-ODtCcC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=kNZHC-ODtCcC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=kNZHC-ODtCcC&printsec=frontcover&dq=programming&hl=&cd=3&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=kNZHC-ODtCcC&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_In_Basic.html?hl=&id=kNZHC-ODtCcC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=kNZHC-ODtCcC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"Rl-F95_f0GoC\",\n" +
            "etag: \"gkXNXI7j7F4\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/Rl-F95_f0GoC\",\n" +
            "volumeInfo: {\n" +
            "title: \"COMPUTER PROGRAMMING IN C\",\n" +
            "authors: [\n" +
            "\"V. RAJARAMAN\"\n" +
            "],\n" +
            "publisher: \"PHI Learning Pvt. Ltd.\",\n" +
            "publishedDate: \"1994-01-01\",\n" +
            "description: \"This book introduces computer programming to a beginner using the programming language C. The version of C used is the one standardised by the American National Standards Institute (ANSI C). C has rapidly gained users due to its efficiency, rich data structure, variety of operators and affinity to UNIX operating system. C is a difficult language to learn if it is not methodically approached. Our attempt has been to introduce the basic aspects of C to enable the student to quickly start writing C programs and postpone more difficult features of C to later chapters. The methodology of presentation closely follows the one used by the author in his popular book on PASCAL programming. Those who know PASCAL will find it very easy to learn C using this book.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"812030859X\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9788120308596\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 372,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "averageRating: 4,\n" +
            "ratingsCount: 4,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: true,\n" +
            "contentVersion: \"0.1.1.0.preview.1\",\n" +
            "panelizationSummary: {\n" +
            "containsEpubBubbles: false,\n" +
            "containsImageBubbles: false\n" +
            "},\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=Rl-F95_f0GoC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=Rl-F95_f0GoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=Rl-F95_f0GoC&printsec=frontcover&dq=programming&hl=&cd=4&source=gbs_api\",\n" +
            "infoLink: \"https://play.google.com/store/books/details?id=Rl-F95_f0GoC&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-Rl-F95_f0GoC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"FOR_SALE\",\n" +
            "isEbook: true,\n" +
            "listPrice: {\n" +
            "amount: 3.79,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amount: 2.88,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "buyLink: \"https://play.google.com/store/books/details?id=Rl-F95_f0GoC&rdid=book-Rl-F95_f0GoC&rdot=1&source=gbs_api\",\n" +
            "offers: [\n" +
            "{\n" +
            "finskyOfferType: 1,\n" +
            "listPrice: {\n" +
            "amountInMicros: 3790000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amountInMicros: 2880000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "giftable: true\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/COMPUTER_PROGRAMMING_IN_C-sample-pdf.acsm?id=Rl-F95_f0GoC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=Rl-F95_f0GoC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"This book introduces computer programming to a beginner using the programming language C. The version of C used is the one standardised by the American National Standards Institute (ANSI C). C has rapidly gained users due to its efficiency, ...\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"MZRt-W8Hq7UC\",\n" +
            "etag: \"VrAaqqVflhU\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/MZRt-W8Hq7UC\",\n" +
            "volumeInfo: {\n" +
            "title: \"Programming for TV, Radio, and the Internet\",\n" +
            "subtitle: \"Strategy, Development, and Evaluation\",\n" +
            "authors: [\n" +
            "\"Philippe Perebinossoff\",\n" +
            "\"Brian Gross\",\n" +
            "\"Lynne S. Gross\"\n" +
            "],\n" +
            "publisher: \"Taylor & Francis\",\n" +
            "publishedDate: \"2005\",\n" +
            "description: \"Where do program ideas come from? How are concepts developed into saleable productions? Who do you talk to about getting a show produced? How do you schedule shows on the lineup? What do you do if a series is in trouble? The answers to these questions, and many more, can be found in this comprehensive, in-depth look at the roles and responsibilities of the electronic media programmer. Topics include: Network relationships with affiliates, the expanded market of syndication, sources of programming for stations and networks, research and its role in programming decisions, fundamental appeals to an audience and what qualities are tied to success, outside forces that influence programming, strategies for launching new programs or saving old ones. Includes real-life examples taken from the authors' experiences, and 250+ illustrations! * Completely updated to include: new programming forms, changes in programming style, and more! * Updated Glossary! * Study questions for each chapter * Companion website for students and Instructor's Manual\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780240806822\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0240806824\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 324,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "averageRating: 4,\n" +
            "ratingsCount: 1,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"preview-1.0.0\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=MZRt-W8Hq7UC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=MZRt-W8Hq7UC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=MZRt-W8Hq7UC&printsec=frontcover&dq=programming&hl=&cd=5&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=MZRt-W8Hq7UC&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_for_TV_Radio_and_the_Interne.html?hl=&id=MZRt-W8Hq7UC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=MZRt-W8Hq7UC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"Where do program ideas come from?\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"Zw0jqouq61gC\",\n" +
            "etag: \"eAOhxK0sEZc\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/Zw0jqouq61gC\",\n" +
            "volumeInfo: {\n" +
            "title: \"Programming with C++\",\n" +
            "authors: [\n" +
            "\"Ravichandran\"\n" +
            "],\n" +
            "publisher: \"Tata McGraw-Hill Education\",\n" +
            "publishedDate: \"2011\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0070681899\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780070681897\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 843,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"C++ (Computer program language)\"\n" +
            "],\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"0.0.1.0.preview.1\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=Zw0jqouq61gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=Zw0jqouq61gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=Zw0jqouq61gC&printsec=frontcover&dq=programming&hl=&cd=6&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=Zw0jqouq61gC&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_with_C++.html?hl=&id=Zw0jqouq61gC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=Zw0jqouq61gC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"nTzwm3JZmIgC\",\n" +
            "etag: \"xB0HianswP0\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/nTzwm3JZmIgC\",\n" +
            "volumeInfo: {\n" +
            "title: \"Basic Computer Programming\",\n" +
            "authors: [\n" +
            "\"V.K. Jain\"\n" +
            "],\n" +
            "publisher: \"Pustak Mahal\",\n" +
            "publishedDate: \"2004-11\",\n" +
            "description: \"Thinking about Computer Programming as a career option? Completely revised and updated, this basic computer programming book can launch you onto a bright career. Meant for both freshers as well as advanced users,it is an authentic volume for learners to use a computer without any outside help. the guide is designed for self-help learning. Some salient features: *Historical evolution of the computer. *Computer characteristics, anatomy & architecture. *Flow charts, Getting started with BASIC, Arithmetic / Input / Control / Conditional Statement. *Putting data out of computers. *Some programming applications, Arrays, Library, user defined functions; Subroutines, Sequential files. *System commands; Programming design & problem solving.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"8122306373\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9788122306378\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 260,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"BASIC (Computer program language)\"\n" +
            "],\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: true,\n" +
            "contentVersion: \"0.0.1.0.preview.1\",\n" +
            "panelizationSummary: {\n" +
            "containsEpubBubbles: false,\n" +
            "containsImageBubbles: false\n" +
            "},\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=nTzwm3JZmIgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=nTzwm3JZmIgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=nTzwm3JZmIgC&printsec=frontcover&dq=programming&hl=&cd=7&source=gbs_api\",\n" +
            "infoLink: \"https://play.google.com/store/books/details?id=nTzwm3JZmIgC&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-nTzwm3JZmIgC\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"FOR_SALE\",\n" +
            "isEbook: true,\n" +
            "listPrice: {\n" +
            "amount: 3.99,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amount: 3.03,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "buyLink: \"https://play.google.com/store/books/details?id=nTzwm3JZmIgC&rdid=book-nTzwm3JZmIgC&rdot=1&source=gbs_api\",\n" +
            "offers: [\n" +
            "{\n" +
            "finskyOfferType: 1,\n" +
            "listPrice: {\n" +
            "amountInMicros: 3990000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amountInMicros: 3030000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "giftable: true\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/Basic_Computer_Programming-sample-pdf.acsm?id=nTzwm3JZmIgC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=nTzwm3JZmIgC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"Meant for both freshers as well as advanced users,it is an authentic volume for learners to use a computer without any outside help. the guide is designed for self-help learning.\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"UCFDDAAAQBAJ\",\n" +
            "etag: \"JPythsm2MfY\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/UCFDDAAAQBAJ\",\n" +
            "volumeInfo: {\n" +
            "title: \"A First Course in Programming with C\",\n" +
            "authors: [\n" +
            "\"T. Jeyapoovan\"\n" +
            "],\n" +
            "publisher: \"Vikas Publishing House\",\n" +
            "publishedDate: \"2004-07-01\",\n" +
            "description: \"C is a popular programming language which is commonly used by scientists and engineers to write programs for any specific application. C is also a widely accepted programming language in the software industries. This beginner’s guide to computer programming is for student programmers to effectively write programs for solving numerical problems. All that is required of a beginner programmer is not experience in computing but interest in computing. The programs illustrated in the book have been accumulated, experimented and tested by the author during his teaching of the subject to a few thousand students in over a decade. In addition, numerous problems are adapted form university question papers. Short questions and answers and objective questions are an added feature. All these would build confidence of the students and those appearing for interview/viva voce in a practical lab. The special topic of the book is C graphics and animation which helps students develop simple programs to generate geometrical and graphical objects.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9788125912118\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"8125912118\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 24,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"preview-1.0.0\",\n" +
            "panelizationSummary: {\n" +
            "containsEpubBubbles: false,\n" +
            "containsImageBubbles: false\n" +
            "},\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=UCFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=UCFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=UCFDDAAAQBAJ&printsec=frontcover&dq=programming&hl=&cd=8&source=gbs_api\",\n" +
            "infoLink: \"https://play.google.com/store/books/details?id=UCFDDAAAQBAJ&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-UCFDDAAAQBAJ\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"FOR_SALE\",\n" +
            "isEbook: true,\n" +
            "listPrice: {\n" +
            "amount: 15.99,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amount: 9.99,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "buyLink: \"https://play.google.com/store/books/details?id=UCFDDAAAQBAJ&rdid=book-UCFDDAAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "offers: [\n" +
            "{\n" +
            "finskyOfferType: 1,\n" +
            "listPrice: {\n" +
            "amountInMicros: 15990000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amountInMicros: 9990000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "giftable: true\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/A_First_Course_in_Programming_with_C-sample-pdf.acsm?id=UCFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=UCFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"C is also a widely accepted programming language in the software industries. This beginner’s guide to computer programming is for student programmers to effectively write programs for solving numerical problems.\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"JzUNn6uUxm0C\",\n" +
            "etag: \"94Vmu9KoMQ0\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/JzUNn6uUxm0C\",\n" +
            "volumeInfo: {\n" +
            "title: \"The Formal Semantics of Programming Languages\",\n" +
            "subtitle: \"An Introduction\",\n" +
            "authors: [\n" +
            "\"Glynn Winskel\"\n" +
            "],\n" +
            "publisher: \"MIT Press\",\n" +
            "publishedDate: \"1993\",\n" +
            "description: \"The Formal Semantics of Programming Languages provides the basic mathematical techniques necessary for those who are beginning a study of the semantics and logics of programming languages. These techniques will allow students to invent, formalize, and justify rules with which to reason about a variety of programming languages. Although the treatment is elementary, several of the topics covered are drawn from recent research, including the vital area of concurency. The book contains many exercises ranging from simple to miniprojects.Starting with basic set theory, structural operational semantics is introduced as a way to define the meaning of programming languages along with associated proof techniques. Denotational and axiomatic semantics are illustrated on a simple language of while-programs, and fall proofs are given of the equivalence of the operational and denotational semantics and soundness and relative completeness of the axiomatic semantics. A proof of Godel's incompleteness theorem, which emphasizes the impossibility of achieving a fully complete axiomatic semantics, is included. It is supported by an appendix providing an introduction to the theory of computability based on while-programs.Following a presentation of domain theory, the semantics and methods of proof for several functional languages are treated. The simplest language is that of recursion equations with both call-by-value and call-by-name evaluation. This work is extended to lan guages with higher and recursive types, including a treatment of the eager and lazy lambda-calculi. Throughout, the relationship between denotational and operational semantics is stressed, and the proofs of the correspondence between the operation and denotational semantics are provided. The treatment of recursive types - one of the more advanced parts of the book - relies on the use of information systems to represent domains. The book concludes with a chapter on parallel programming languages, accompanied by a discussion of methods for specifying and verifying nondeterministic and parallel programs.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0262731037\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780262731034\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: false,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 361,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "averageRating: 3,\n" +
            "ratingsCount: 2,\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"0.0.1.0.preview.1\",\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=JzUNn6uUxm0C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=JzUNn6uUxm0C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=JzUNn6uUxm0C&printsec=frontcover&dq=programming&hl=&cd=9&source=gbs_api\",\n" +
            "infoLink: \"http://books.google.com/books?id=JzUNn6uUxm0C&dq=programming&hl=&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://books.google.com/books/about/The_Formal_Semantics_of_Programming_Lang.html?hl=&id=JzUNn6uUxm0C\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"NOT_FOR_SALE\",\n" +
            "isEbook: false\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: false\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=JzUNn6uUxm0C&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"The simplest language is that of recursion equations with both call-by-value and call-by-name evaluation. This work is extended to lan guages with higher and recursive types, including a treatment of the eager and lazy lambda-calculi.\"\n" +
            "}\n" +
            "},\n" +
            "{\n" +
            "kind: \"books#volume\",\n" +
            "id: \"ytq_DgAAQBAJ\",\n" +
            "etag: \"EePSgOfW1eg\",\n" +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/ytq_DgAAQBAJ\",\n" +
            "volumeInfo: {\n" +
            "title: \"Confident Coding\",\n" +
            "subtitle: \"Master the Fundamentals of Code and Supercharge Your Career\",\n" +
            "authors: [\n" +
            "\"Rob Percival\"\n" +
            "],\n" +
            "publisher: \"Kogan Page Publishers\",\n" +
            "publishedDate: \"2017-05-03\",\n" +
            "description: \"If you want to master the fundamentals of coding and kick start your career, Confident Coding is the book for you. Everyone has a digital life, but too few truly understand how the software that dominates the world actually works. Coding is one of the most in demand skills on the job market and grasping the basics can advance your creative potential and make you stand out from the crowd. Rob Percival gives you a step-by-step learning guide to HTML, CSS, JavaScript, Python, building iPhone apps, building Android apps and debugging. On reading this book and honing your skills through practice, you will be able to code in each of these languages, build your own website, build your own app and have the confidence to supercharge your employability. Confident Coding provides you with the roadmap you need to enhance your professional life through coding, with insightful and inspirational guidance, including real life success stories, on how to use your new skills. The ability to code can give your CV the edge on the competition, give you greater autonomy and improve your work performance. If you are a self-employed entrepreneur, being able to create your own website or app can grant you valuable freedom and revolutionize your business. If you are an aspiring developer, this book will give you the building blocks to embark on this career path.\",\n" +
            "industryIdentifiers: [\n" +
            "{\n" +
            "type: \"ISBN_13\",\n" +
            "identifier: \"9780749479640\"\n" +
            "},\n" +
            "{\n" +
            "type: \"ISBN_10\",\n" +
            "identifier: \"0749479647\"\n" +
            "}\n" +
            "],\n" +
            "readingModes: {\n" +
            "text: true,\n" +
            "image: true\n" +
            "},\n" +
            "pageCount: 272,\n" +
            "printType: \"BOOK\",\n" +
            "categories: [\n" +
            "\"Computers\"\n" +
            "],\n" +
            "maturityRating: \"NOT_MATURE\",\n" +
            "allowAnonLogging: false,\n" +
            "contentVersion: \"preview-1.0.0\",\n" +
            "panelizationSummary: {\n" +
            "containsEpubBubbles: false,\n" +
            "containsImageBubbles: false\n" +
            "},\n" +
            "imageLinks: {\n" +
            "smallThumbnail: \"http://books.google.com/books/content?id=ytq_DgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "thumbnail: \"http://books.google.com/books/content?id=ytq_DgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "},\n" +
            "language: \"en\",\n" +
            "previewLink: \"http://books.google.com/books?id=ytq_DgAAQBAJ&printsec=frontcover&dq=programming&hl=&cd=10&source=gbs_api\",\n" +
            "infoLink: \"https://play.google.com/store/books/details?id=ytq_DgAAQBAJ&source=gbs_api\",\n" +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-ytq_DgAAQBAJ\"\n" +
            "},\n" +
            "saleInfo: {\n" +
            "country: \"US\",\n" +
            "saleability: \"FOR_SALE\",\n" +
            "isEbook: true,\n" +
            "listPrice: {\n" +
            "amount: 19.95,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amount: 9.99,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "buyLink: \"https://play.google.com/store/books/details?id=ytq_DgAAQBAJ&rdid=book-ytq_DgAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "offers: [\n" +
            "{\n" +
            "finskyOfferType: 1,\n" +
            "listPrice: {\n" +
            "amountInMicros: 19950000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "retailPrice: {\n" +
            "amountInMicros: 9990000,\n" +
            "currencyCode: \"USD\"\n" +
            "},\n" +
            "giftable: true\n" +
            "}\n" +
            "]\n" +
            "},\n" +
            "accessInfo: {\n" +
            "country: \"US\",\n" +
            "viewability: \"PARTIAL\",\n" +
            "embeddable: true,\n" +
            "publicDomain: false,\n" +
            "textToSpeechPermission: \"ALLOWED\",\n" +
            "epub: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/Confident_Coding-sample-epub.acsm?id=ytq_DgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "pdf: {\n" +
            "isAvailable: true,\n" +
            "acsTokenLink: \"http://books.google.com/books/download/Confident_Coding-sample-pdf.acsm?id=ytq_DgAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "},\n" +
            "webReaderLink: \"http://play.google.com/books/reader?id=ytq_DgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "accessViewStatus: \"SAMPLE\",\n" +
            "quoteSharingAllowed: false\n" +
            "},\n" +
            "searchInfo: {\n" +
            "textSnippet: \"If you want to master the fundamentals of coding and kick start your career, Confident Coding is the book for you. Everyone has a digital life, but too few truly understand how the software that dominates the world actually works.\"\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ListView
        mListView = findViewById(R.id.list);

        // Set up the adapter
        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        mListView.setAdapter(mAdapter);
        mAdapter.addAll(QueryUtils.extractBooks(jsonData));
    }
}
