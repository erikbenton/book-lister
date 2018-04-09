package com.example.android.booklister;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // ListView for main activity
    private ListView mListView;
    private BookAdapter mAdapter;

    // Hardcoded JSON data
    private String jsonData =
            "{" +
            "kind: \"books#volumes\"," +
            "totalItems: 3742," +
            "items: [" +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"ti6zoAC9Ph8C\"," +
            "etag: \"UyZOvRcFWUg\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/ti6zoAC9Ph8C\"," +
            "volumeInfo: {" +
            "title: \"Types and Programming Languages\"," +
            "authors: [" +
            "\"Benjamin C. Pierce\"" +
            "]," +
            "publisher: \"MIT Press\"," +
            "publishedDate: \"2002\"," +
            "description: \"A comprehensive introduction to type systems and programming languages.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0262162091\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780262162098\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 623," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "averageRating: 4," +
            "ratingsCount: 9," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"preview-1.0.0\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=ti6zoAC9Ph8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=ti6zoAC9Ph8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=ti6zoAC9Ph8C&printsec=frontcover&dq=programming&hl=&cd=1&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=ti6zoAC9Ph8C&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Types_and_Programming_Languages.html?hl=&id=ti6zoAC9Ph8C\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: false" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=ti6zoAC9Ph8C&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"Mathematical Preliminaries - Untyped Systems - Untyped Arithmetic Expressions - An ML Implementation of Arithmetic Expressions - The Untyped Lambda-Calculus - Nameless Representation of Terms - An ML Implementation of the Lambda-Calculus - ...\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"7Uh8XGfJbEIC\"," +
            "etag: \"Vd+AobBdubM\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/7Uh8XGfJbEIC\"," +
            "volumeInfo: {" +
            "title: \"Concepts in Programming Languages\"," +
            "authors: [" +
            "\"John C. Mitchell\"" +
            "]," +
            "publisher: \"Cambridge University Press\"," +
            "publishedDate: \"2003\"," +
            "description: \"A comprehensive undergraduate textbook covering both theory and practical design issues, with an emphasis on object-oriented languages.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0521780985\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780521780988\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 529," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "averageRating: 3.5," +
            "ratingsCount: 5," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"1.0.1.0.preview.1\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=7Uh8XGfJbEIC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=7Uh8XGfJbEIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=7Uh8XGfJbEIC&printsec=frontcover&dq=programming&hl=&cd=2&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=7Uh8XGfJbEIC&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Concepts_in_Programming_Languages.html?hl=&id=7Uh8XGfJbEIC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/Concepts_in_Programming_Languages-sample-pdf.acsm?id=7Uh8XGfJbEIC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=7Uh8XGfJbEIC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"A comprehensive undergraduate textbook covering both theory and practical design issues, with an emphasis on object-oriented languages.\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"kNZHC-ODtCcC\"," +
            "etag: \"twhBxMe4IPY\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/kNZHC-ODtCcC\"," +
            "volumeInfo: {" +
            "title: \"Programming In Basic\"," +
            "authors: [" +
            "\"Balagurusamy\"" +
            "]," +
            "publisher: \"Tata McGraw-Hill Education\"," +
            "publishedDate: \"1991\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0074600559\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780074600559\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 317," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"BASIC (Computer program language)\"" +
            "]," +
            "averageRating: 4.5," +
            "ratingsCount: 2," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"0.0.1.0.preview.1\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=kNZHC-ODtCcC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=kNZHC-ODtCcC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=kNZHC-ODtCcC&printsec=frontcover&dq=programming&hl=&cd=3&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=kNZHC-ODtCcC&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_In_Basic.html?hl=&id=kNZHC-ODtCcC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: false" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=kNZHC-ODtCcC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"Rl-F95_f0GoC\"," +
            "etag: \"gkXNXI7j7F4\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/Rl-F95_f0GoC\"," +
            "volumeInfo: {" +
            "title: \"COMPUTER PROGRAMMING IN C\"," +
            "authors: [" +
            "\"V. RAJARAMAN\"" +
            "]," +
            "publisher: \"PHI Learning Pvt. Ltd.\"," +
            "publishedDate: \"1994-01-01\"," +
            "description: \"This book introduces computer programming to a beginner using the programming language C. The version of C used is the one standardised by the American National Standards Institute (ANSI C). C has rapidly gained users due to its efficiency, rich data structure, variety of operators and affinity to UNIX operating system. C is a difficult language to learn if it is not methodically approached. Our attempt has been to introduce the basic aspects of C to enable the student to quickly start writing C programs and postpone more difficult features of C to later chapters. The methodology of presentation closely follows the one used by the author in his popular book on PASCAL programming. Those who know PASCAL will find it very easy to learn C using this book.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"812030859X\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9788120308596\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 372," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "averageRating: 4," +
            "ratingsCount: 4," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: true," +
            "contentVersion: \"0.1.1.0.preview.1\"," +
            "panelizationSummary: {" +
            "containsEpubBubbles: false," +
            "containsImageBubbles: false" +
            "}," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=Rl-F95_f0GoC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=Rl-F95_f0GoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=Rl-F95_f0GoC&printsec=frontcover&dq=programming&hl=&cd=4&source=gbs_api\"," +
            "infoLink: \"https://play.google.com/store/books/details?id=Rl-F95_f0GoC&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-Rl-F95_f0GoC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"FOR_SALE\"," +
            "isEbook: true," +
            "listPrice: {" +
            "amount: 3.79," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amount: 2.88," +
            "currencyCode: \"USD\"" +
            "}," +
            "buyLink: \"https://play.google.com/store/books/details?id=Rl-F95_f0GoC&rdid=book-Rl-F95_f0GoC&rdot=1&source=gbs_api\"," +
            "offers: [" +
            "{" +
            "finskyOfferType: 1," +
            "listPrice: {" +
            "amountInMicros: 3790000," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amountInMicros: 2880000," +
            "currencyCode: \"USD\"" +
            "}," +
            "giftable: true" +
            "}" +
            "]" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/COMPUTER_PROGRAMMING_IN_C-sample-pdf.acsm?id=Rl-F95_f0GoC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=Rl-F95_f0GoC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"This book introduces computer programming to a beginner using the programming language C. The version of C used is the one standardised by the American National Standards Institute (ANSI C). C has rapidly gained users due to its efficiency, ...\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"MZRt-W8Hq7UC\"," +
            "etag: \"VrAaqqVflhU\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/MZRt-W8Hq7UC\"," +
            "volumeInfo: {" +
            "title: \"Programming for TV, Radio, and the Internet\"," +
            "subtitle: \"Strategy, Development, and Evaluation\"," +
            "authors: [" +
            "\"Philippe Perebinossoff\"," +
            "\"Brian Gross\"," +
            "\"Lynne S. Gross\"" +
            "]," +
            "publisher: \"Taylor & Francis\"," +
            "publishedDate: \"2005\"," +
            "description: \"Where do program ideas come from? How are concepts developed into saleable productions? Who do you talk to about getting a show produced? How do you schedule shows on the lineup? What do you do if a series is in trouble? The answers to these questions, and many more, can be found in this comprehensive, in-depth look at the roles and responsibilities of the electronic media programmer. Topics include: Network relationships with affiliates, the expanded market of syndication, sources of programming for stations and networks, research and its role in programming decisions, fundamental appeals to an audience and what qualities are tied to success, outside forces that influence programming, strategies for launching new programs or saving old ones. Includes real-life examples taken from the authors' experiences, and 250+ illustrations! * Completely updated to include: new programming forms, changes in programming style, and more! * Updated Glossary! * Study questions for each chapter * Companion website for students and Instructor's Manual\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780240806822\"" +
            "}," +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0240806824\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 324," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "averageRating: 4," +
            "ratingsCount: 1," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"preview-1.0.0\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=MZRt-W8Hq7UC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=MZRt-W8Hq7UC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=MZRt-W8Hq7UC&printsec=frontcover&dq=programming&hl=&cd=5&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=MZRt-W8Hq7UC&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_for_TV_Radio_and_the_Interne.html?hl=&id=MZRt-W8Hq7UC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: false" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=MZRt-W8Hq7UC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"Where do program ideas come from?\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"Zw0jqouq61gC\"," +
            "etag: \"eAOhxK0sEZc\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/Zw0jqouq61gC\"," +
            "volumeInfo: {" +
            "title: \"Programming with C++\"," +
            "authors: [" +
            "\"Ravichandran\"" +
            "]," +
            "publisher: \"Tata McGraw-Hill Education\"," +
            "publishedDate: \"2011\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0070681899\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780070681897\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 843," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"C++ (Computer program language)\"" +
            "]," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"0.0.1.0.preview.1\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=Zw0jqouq61gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=Zw0jqouq61gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=Zw0jqouq61gC&printsec=frontcover&dq=programming&hl=&cd=6&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=Zw0jqouq61gC&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/Programming_with_C++.html?hl=&id=Zw0jqouq61gC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: false" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=Zw0jqouq61gC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"nTzwm3JZmIgC\"," +
            "etag: \"xB0HianswP0\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/nTzwm3JZmIgC\"," +
            "volumeInfo: {" +
            "title: \"Basic Computer Programming\"," +
            "authors: [" +
            "\"V.K. Jain\"" +
            "]," +
            "publisher: \"Pustak Mahal\"," +
            "publishedDate: \"2004-11\"," +
            "description: \"Thinking about Computer Programming as a career option? Completely revised and updated, this basic computer programming book can launch you onto a bright career. Meant for both freshers as well as advanced users,it is an authentic volume for learners to use a computer without any outside help. the guide is designed for self-help learning. Some salient features: *Historical evolution of the computer. *Computer characteristics, anatomy & architecture. *Flow charts, Getting started with BASIC, Arithmetic / Input / Control / Conditional Statement. *Putting data out of computers. *Some programming applications, Arrays, Library, user defined functions; Subroutines, Sequential files. *System commands; Programming design & problem solving.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"8122306373\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9788122306378\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 260," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"BASIC (Computer program language)\"" +
            "]," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: true," +
            "contentVersion: \"0.0.1.0.preview.1\"," +
            "panelizationSummary: {" +
            "containsEpubBubbles: false," +
            "containsImageBubbles: false" +
            "}," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=nTzwm3JZmIgC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=nTzwm3JZmIgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=nTzwm3JZmIgC&printsec=frontcover&dq=programming&hl=&cd=7&source=gbs_api\"," +
            "infoLink: \"https://play.google.com/store/books/details?id=nTzwm3JZmIgC&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-nTzwm3JZmIgC\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"FOR_SALE\"," +
            "isEbook: true," +
            "listPrice: {" +
            "amount: 3.99," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amount: 3.03," +
            "currencyCode: \"USD\"" +
            "}," +
            "buyLink: \"https://play.google.com/store/books/details?id=nTzwm3JZmIgC&rdid=book-nTzwm3JZmIgC&rdot=1&source=gbs_api\"," +
            "offers: [" +
            "{" +
            "finskyOfferType: 1," +
            "listPrice: {" +
            "amountInMicros: 3990000," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amountInMicros: 3030000," +
            "currencyCode: \"USD\"" +
            "}," +
            "giftable: true" +
            "}" +
            "]" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/Basic_Computer_Programming-sample-pdf.acsm?id=nTzwm3JZmIgC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=nTzwm3JZmIgC&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"Meant for both freshers as well as advanced users,it is an authentic volume for learners to use a computer without any outside help. the guide is designed for self-help learning.\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"UCFDDAAAQBAJ\"," +
            "etag: \"JPythsm2MfY\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/UCFDDAAAQBAJ\"," +
            "volumeInfo: {" +
            "title: \"A First Course in Programming with C\"," +
            "authors: [" +
            "\"T. Jeyapoovan\"" +
            "]," +
            "publisher: \"Vikas Publishing House\"," +
            "publishedDate: \"2004-07-01\"," +
            "description: \"C is a popular programming language which is commonly used by scientists and engineers to write programs for any specific application. C is also a widely accepted programming language in the software industries. This beginner’s guide to computer programming is for student programmers to effectively write programs for solving numerical problems. All that is required of a beginner programmer is not experience in computing but interest in computing. The programs illustrated in the book have been accumulated, experimented and tested by the author during his teaching of the subject to a few thousand students in over a decade. In addition, numerous problems are adapted form university question papers. Short questions and answers and objective questions are an added feature. All these would build confidence of the students and those appearing for interview/viva voce in a practical lab. The special topic of the book is C graphics and animation which helps students develop simple programs to generate geometrical and graphical objects.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9788125912118\"" +
            "}," +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"8125912118\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 24," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"preview-1.0.0\"," +
            "panelizationSummary: {" +
            "containsEpubBubbles: false," +
            "containsImageBubbles: false" +
            "}," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=UCFDDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=UCFDDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=UCFDDAAAQBAJ&printsec=frontcover&dq=programming&hl=&cd=8&source=gbs_api\"," +
            "infoLink: \"https://play.google.com/store/books/details?id=UCFDDAAAQBAJ&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-UCFDDAAAQBAJ\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"FOR_SALE\"," +
            "isEbook: true," +
            "listPrice: {" +
            "amount: 15.99," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amount: 9.99," +
            "currencyCode: \"USD\"" +
            "}," +
            "buyLink: \"https://play.google.com/store/books/details?id=UCFDDAAAQBAJ&rdid=book-UCFDDAAAQBAJ&rdot=1&source=gbs_api\"," +
            "offers: [" +
            "{" +
            "finskyOfferType: 1," +
            "listPrice: {" +
            "amountInMicros: 15990000," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amountInMicros: 9990000," +
            "currencyCode: \"USD\"" +
            "}," +
            "giftable: true" +
            "}" +
            "]" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/A_First_Course_in_Programming_with_C-sample-pdf.acsm?id=UCFDDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=UCFDDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"C is also a widely accepted programming language in the software industries. This beginner’s guide to computer programming is for student programmers to effectively write programs for solving numerical problems.\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"JzUNn6uUxm0C\"," +
            "etag: \"94Vmu9KoMQ0\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/JzUNn6uUxm0C\"," +
            "volumeInfo: {" +
            "title: \"The Formal Semantics of Programming Languages\"," +
            "subtitle: \"An Introduction\"," +
            "authors: [" +
            "\"Glynn Winskel\"" +
            "]," +
            "publisher: \"MIT Press\"," +
            "publishedDate: \"1993\"," +
            "description: \"The Formal Semantics of Programming Languages provides the basic mathematical techniques necessary for those who are beginning a study of the semantics and logics of programming languages. These techniques will allow students to invent, formalize, and justify rules with which to reason about a variety of programming languages. Although the treatment is elementary, several of the topics covered are drawn from recent research, including the vital area of concurency. The book contains many exercises ranging from simple to miniprojects.Starting with basic set theory, structural operational semantics is introduced as a way to define the meaning of programming languages along with associated proof techniques. Denotational and axiomatic semantics are illustrated on a simple language of while-programs, and fall proofs are given of the equivalence of the operational and denotational semantics and soundness and relative completeness of the axiomatic semantics. A proof of Godel's incompleteness theorem, which emphasizes the impossibility of achieving a fully complete axiomatic semantics, is included. It is supported by an appendix providing an introduction to the theory of computability based on while-programs.Following a presentation of domain theory, the semantics and methods of proof for several functional languages are treated. The simplest language is that of recursion equations with both call-by-value and call-by-name evaluation. This work is extended to lan guages with higher and recursive types, including a treatment of the eager and lazy lambda-calculi. Throughout, the relationship between denotational and operational semantics is stressed, and the proofs of the correspondence between the operation and denotational semantics are provided. The treatment of recursive types - one of the more advanced parts of the book - relies on the use of information systems to represent domains. The book concludes with a chapter on parallel programming languages, accompanied by a discussion of methods for specifying and verifying nondeterministic and parallel programs.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0262731037\"" +
            "}," +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780262731034\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: false," +
            "image: true" +
            "}," +
            "pageCount: 361," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "averageRating: 3," +
            "ratingsCount: 2," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"0.0.1.0.preview.1\"," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=JzUNn6uUxm0C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=JzUNn6uUxm0C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=JzUNn6uUxm0C&printsec=frontcover&dq=programming&hl=&cd=9&source=gbs_api\"," +
            "infoLink: \"http://books.google.com/books?id=JzUNn6uUxm0C&dq=programming&hl=&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://books.google.com/books/about/The_Formal_Semantics_of_Programming_Lang.html?hl=&id=JzUNn6uUxm0C\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"NOT_FOR_SALE\"," +
            "isEbook: false" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: false" +
            "}," +
            "pdf: {" +
            "isAvailable: false" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=JzUNn6uUxm0C&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"The simplest language is that of recursion equations with both call-by-value and call-by-name evaluation. This work is extended to lan guages with higher and recursive types, including a treatment of the eager and lazy lambda-calculi.\"" +
            "}" +
            "}," +
            "{" +
            "kind: \"books#volume\"," +
            "id: \"ytq_DgAAQBAJ\"," +
            "etag: \"EePSgOfW1eg\"," +
            "selfLink: \"https://www.googleapis.com/books/v1/volumes/ytq_DgAAQBAJ\"," +
            "volumeInfo: {" +
            "title: \"Confident Coding\"," +
            "subtitle: \"Master the Fundamentals of Code and Supercharge Your Career\"," +
            "authors: [" +
            "\"Rob Percival\"" +
            "]," +
            "publisher: \"Kogan Page Publishers\"," +
            "publishedDate: \"2017-05-03\"," +
            "description: \"If you want to master the fundamentals of coding and kick start your career, Confident Coding is the book for you. Everyone has a digital life, but too few truly understand how the software that dominates the world actually works. Coding is one of the most in demand skills on the job market and grasping the basics can advance your creative potential and make you stand out from the crowd. Rob Percival gives you a step-by-step learning guide to HTML, CSS, JavaScript, Python, building iPhone apps, building Android apps and debugging. On reading this book and honing your skills through practice, you will be able to code in each of these languages, build your own website, build your own app and have the confidence to supercharge your employability. Confident Coding provides you with the roadmap you need to enhance your professional life through coding, with insightful and inspirational guidance, including real life success stories, on how to use your new skills. The ability to code can give your CV the edge on the competition, give you greater autonomy and improve your work performance. If you are a self-employed entrepreneur, being able to create your own website or app can grant you valuable freedom and revolutionize your business. If you are an aspiring developer, this book will give you the building blocks to embark on this career path.\"," +
            "industryIdentifiers: [" +
            "{" +
            "type: \"ISBN_13\"," +
            "identifier: \"9780749479640\"" +
            "}," +
            "{" +
            "type: \"ISBN_10\"," +
            "identifier: \"0749479647\"" +
            "}" +
            "]," +
            "readingModes: {" +
            "text: true," +
            "image: true" +
            "}," +
            "pageCount: 272," +
            "printType: \"BOOK\"," +
            "categories: [" +
            "\"Computers\"" +
            "]," +
            "maturityRating: \"NOT_MATURE\"," +
            "allowAnonLogging: false," +
            "contentVersion: \"preview-1.0.0\"," +
            "panelizationSummary: {" +
            "containsEpubBubbles: false," +
            "containsImageBubbles: false" +
            "}," +
            "imageLinks: {" +
            "smallThumbnail: \"http://books.google.com/books/content?id=ytq_DgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "thumbnail: \"http://books.google.com/books/content?id=ytq_DgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"" +
            "}," +
            "language: \"en\"," +
            "previewLink: \"http://books.google.com/books?id=ytq_DgAAQBAJ&printsec=frontcover&dq=programming&hl=&cd=10&source=gbs_api\"," +
            "infoLink: \"https://play.google.com/store/books/details?id=ytq_DgAAQBAJ&source=gbs_api\"," +
            "canonicalVolumeLink: \"https://market.android.com/details?id=book-ytq_DgAAQBAJ\"" +
            "}," +
            "saleInfo: {" +
            "country: \"US\"," +
            "saleability: \"FOR_SALE\"," +
            "isEbook: true," +
            "listPrice: {" +
            "amount: 19.95," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amount: 9.99," +
            "currencyCode: \"USD\"" +
            "}," +
            "buyLink: \"https://play.google.com/store/books/details?id=ytq_DgAAQBAJ&rdid=book-ytq_DgAAQBAJ&rdot=1&source=gbs_api\"," +
            "offers: [" +
            "{" +
            "finskyOfferType: 1," +
            "listPrice: {" +
            "amountInMicros: 19950000," +
            "currencyCode: \"USD\"" +
            "}," +
            "retailPrice: {" +
            "amountInMicros: 9990000," +
            "currencyCode: \"USD\"" +
            "}," +
            "giftable: true" +
            "}" +
            "]" +
            "}," +
            "accessInfo: {" +
            "country: \"US\"," +
            "viewability: \"PARTIAL\"," +
            "embeddable: true," +
            "publicDomain: false," +
            "textToSpeechPermission: \"ALLOWED\"," +
            "epub: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/Confident_Coding-sample-epub.acsm?id=ytq_DgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "pdf: {" +
            "isAvailable: true," +
            "acsTokenLink: \"http://books.google.com/books/download/Confident_Coding-sample-pdf.acsm?id=ytq_DgAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"" +
            "}," +
            "webReaderLink: \"http://play.google.com/books/reader?id=ytq_DgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\"," +
            "accessViewStatus: \"SAMPLE\"," +
            "quoteSharingAllowed: false" +
            "}," +
            "searchInfo: {" +
            "textSnippet: \"If you want to master the fundamentals of coding and kick start your career, Confident Coding is the book for you. Everyone has a digital life, but too few truly understand how the software that dominates the world actually works.\"" +
            "}" +
            "}" +
            "]" +
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

        // Set Click Listener on each item so that when clicked
        // It goes to the "Info URL" of the book
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Get the book at the current position
                Book book = mAdapter.getItem(position);

                // Get the url from the Book
                String url = book.getUrl();

                //Create Intent to open browser to URL
                Intent openWebpage = new Intent(Intent.ACTION_VIEW);
                openWebpage.setData(Uri.parse(url));
                startActivity(openWebpage);
            }
        });
    }
}
