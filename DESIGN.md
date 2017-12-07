DESIGN.md file for ABC123 Android Application

`Creators: Sishir Yeety, Sojung Kim, Casey White
`
`**(split up categories by Java classes)**
`

GitHub Project Link: https://github.com/sojungkim0917/cs50final
Android Studio User guide was used to assist in navigationa and creation of the app https://developer.android.com/studio/intro/index.html

ABCMain

    This is the main landing page when the app is opened to enter the app through the "Play" button. The layout for this page is
    defined by abc_main.xml in the /app/src/main/res/layout folder.

BeginnerMath (SoJung)

    This is for the level 1 math multiple choice test. The code begins by declaring questions, choices, and answers from BeginnerMathQuestions.java.
    Then it also keeps track of score and number of the question the user has reached. Question length is hardcoded to determine when the
    user went through all questions. The activity begins with first question. Then on clicking choice, if the user is at the end of the test,
    game over dialog pops up. Game over dialog has two possibilities: 1) if user got score of lower than 15, user can either go back to
    main page to select math or literacy or try again 2) if user got score of higher than 15, user can either go watch a short video as
    a reward or go back to main page to select math or literacy. If user is not at the end of the test and has clicked correct answer,
    score goes up by 1. Then the number of question also goes up by 1 and the next question is displayed. The layout for this page is
    defined by the math.xml in the layout folder.
    Used this tutorial to base code off of: https://www.youtube.com/watch?v=JA9s_Fntg_4



BeginnerMathQuestions (SoJung)

    This is level 1 math multiple choice test, choices, and answer bank. The activity is hardcoded due to its relatively short text lengths.
    Arrays of questions, choices, and answers are declared first. Then the getters for questions, choices, and answers are declared. Question
    length is hardcoded because it is set amount. This page does not need a layout xml file because it is a database hardcoded with test questions.
    Used this tutorial to base code off of: https://www.youtube.com/watch?v=JA9s_Fntg_4

Flashcard_lit (Casey)

    This is for the Flashcard functionality for reviewing the alphabet. The image switcher method is a transition widget
    which helps us to add transitions on the images. It is used to animate an image on the screen, in this case the alphabet "flashcards".
    ImageSwitcher switches smoothly between two images and thus provides a way of transitioning from one Image to another through animations,
    in this case by way of a button click.
    The flashcard images are loaded to the drawable resource. Once you provide a resource in your application, you can apply it by
    referencing its resource ID. All resource IDs are defined in your project's R class, which the aapt tool automatically generates.
    When the application is compiled, aapt generates the R class, which contains resource IDs for all the resources in your res/ directory.
    For each type of resource, there is an R subclass (in this case, R.drawable for all drawable resources), and for each resource of that
    type, there is a static integer (R.drawable.picturefilename). This integer is the resource ID that is used to retrieve our resource.r
    by way of an integer array. The images will be called on using setFactory(ViewFactory factory): This method is used to create a new
    view for ImageSwitcher. By using this method we create a new ImageView and replace the old view with the new image. Then the array
    is cycled by an if statement incrementing until the end or beginning of the alphabet is reached. Drawable animation lets us load
    a series of Drawable resources one after another to create an animation. This is a traditional animation in the sense that it is
    created with a sequence of different images, played in order, like a roll of film. The AnimationDrawable class is the basis for
    our Drawable animation (FlashCards). Originally we had planned to also use firebase for the images, however we encountered some
    issues with retreiving the images in the same fashion as we had for the test questions. The flashcard images are loaded to the drawable
    resource. We pull these into an integer array and will be called on using setFactory(ViewFactory factory): This method is used to
    create a new view for ImageSwitcher. By using this method we create a new ImageView and replace the old view with the new image.
    Then the array is cycled by an if statement incrementing until the end or beginning of the alphabet is reached. The "Next" and "Prev"
    buttons use onclicklistener action to initiate the change. This page's layout is defined by flashcard_lit.xml in the layout folder.

    Used this tutorial to base code off of: https://www.youtube.com/watch?v=1xjhtXA3uv4

Homepage (Casey)

    Homepage is the welcome page where user will choose to go to either literacy page or math page. "ABC" button will take you to the literacy
    homepage. "123" Button will take you to the math homepage. The homepage's layout is defined by the homepage.xml file. It is pretty
    straight-forward because it has two buttons to take you to either the 123 or ABC section of our app.

IntermediateMath (SoJung)

    This is for the level 2 math multiple choice test. The code begins by declaring questions, choices, and answers from IntermediateMathQuestions.java.
    Then it also keeps track of score and number of the question the user has reached. Question length is hardcoded to determine when the
    user went through all questions. The activity begins with first question. Then on clicking choice, if the user is at the end of the test,
    game over dialog pops up. Game over dialog has two possibilities: 1) if user got score of lower than 15, user can either go back to
    main page to select math or literacy or try again 2) if user got score of higher than 15, user can either go watch a short video as
    a reward or go back to main page to select math or literacy. If user is not at the end of the test and has clicked correct answer,
    score goes up by 1. Then the number of question also goes up by 1 and the next question is displayed. The layout for this page is
    defined by the math.xml in the layout folder.
    Used this tutorial to base code off of: https://www.youtube.com/watch?v=JA9s_Fntg_4

IntermediateMathQuestions (SoJung)

    This is level 2 math multiple choice test, choices, and answer bank. The activity is hardcoded due to its relatively short text lengths.
    Arrays of questions, choices, and answers are declared first. Then the getters for questions, choices, and answers are declared. Question
    length is hardcoded because it is set amount. This page does not need a layout xml file because it is a database hardcoded with test questions.
    Used this tutorial to base code off of: https://www.youtube.com/watch?v=JA9s_Fntg_4

App.java (Sishir)

    This java class is needed for the Firebase module to run. It is used to instantiate the class that defines the Firebase functions.

Firebase (Sishir)

    For the literacy tests in our app, we decided to use Firebase, which is an cloud computing platform by Google. The alternative was
    to hardcode the question banks into seperate java classes (like what we did for the math questions) or use some sort of SQL database.
    Due to this, we decided against the hard-coding because it would make the .java file too large and confusing to read/access ourselves.
    We decided against the SQL database because we were having a hard time figuring out how to do it correctly. Firebase allows us to
    use their online database without needing to hard-code or use SQL. To add Firebase to our application, a google service JSON file
    had to be added to the app module's root folder. The project-level and app-level gradle files also had to be updated. The questions were
    added to the Firebase interface by typing them up in Excel and then converting them to JSON files to import into their online interface.
    Then the app accesses the Firebase databse by using direct URLs after the JSONs have been imported. For example, the "easy" test is
    stored at XYZ.firebaseio.com/easy. From there, /easy/0/ accceses the first question and then easy/0/question has the text for the question
    and /0/answer or choice1 or choice2 or choice3 or choice4 stores the various different values that are displayed in the test interface.

    cs50-ab.firebaseio.com/easy (accesses stored easy test)
    .com/easy/0/ (accesses question 1 and its information)
    .com/easy/0/question (accesses question text)
    .com/easy/0/choice1 or choice2 or choice3 or choice4 (accesses 4 test choices)
    .com/easy/0/answer (accesses answer from database)

    These are put into the Literacy/Literacy2.java files to access from database.

    Used this tutorial/walkthrough to base code off of: https://youtu.be/-4bZ_rfvBTk

Literacy (Sishir)

    This java class is for the "easy" level of the Literacy multiple-choice test. The layout of this page is defined by literacy.xml. We
    picked that layout of the question displaying in the top and then four multiple choice buttons below. This layout was picked due to its
    simplicicity. Since kids are targeted by the application, it has to be easy to read and straight-forward. The four buttons are defined
    by the ids "choice1/2/3/4". The ID of the text box at the top is "question" and that is where question text (from firebase) displays inside.

    As we get into the code, the top of the page has all of the different modules that have been imported. Two of importance are the text-to-speech
    module and the four that add firebase functionality. From there, we defined the TextView mQuestion field and the four buttons from the layout
    page. mScore and mQuestionNumber are set at 0 to start the test. As the code runs, that int will iterate to the next one and so on. mQuestionlength
    is defined at 20 because each test bank (from Firebase) has 20 questions. In the updateQuestion function, the direct firebase addresses are
    defined for each part of the question; for example, question/choice1,2,3,4/answer.

    As the application is running, it will use the JSON file from the app directly and these firebase addresses to bring and display the questions.
    If the user gets a question right, there is a pop-up that comes up. There, the user will be asked if they want to advance to the next
    question or hear the answer (via the TTS module) AND advance to the next question. In the background, the application is also keeping track of the user's score.
    If the user achieves a score of, at least, 15 out of 20, it will redirect to the LiteracyVideo pages, where the user will see
    a "good job" message and then play a quick kids video.

    To get to the easy literacy test page, the user has to press the "play" action when the app starts up, and then click the ABC button. From there,
    you will see two different buttons on the button half of the page labeled Level 1 and Level 2. This page is called LiteracyHome. If you click on
    the "Level 1" button, it will lead to the Literacy.xml page, which is defined by the Literacy.java class.

    The easy literacy test consists of simple ABC questions, such as filling in the blank of the next alphabeat and matching the lowercase form of a
    certain letter to the uppercase form of the letter. For example "a" goes to "A" and so on. There are 20 questions of these two types. The questions
    were created by Sishir; did not come from an online resource or anything.

    More information about the Firebase function is in the Firebase section of this document.

    Used this tutorial/walkthrough to base code off of: https://youtu.be/-4bZ_rfvBTk

Literacy1Video (SoJung)

    The page has video reward for literacy level 1 test. Videoview is first declared from the layout. The media controller is created
    so that when the user touches the video, the controller pops up from the bottom of the screen. Then the URI for the video is set.
    The video starts upon arriving on the page. After finishing the video, little message comes up saying "Great work." If any error occurs
    during playing the video, the error message will come up. This page's layout is defined by the literacy1video.xml page in the layout folder.
    Used this tutorial to base code off of: http://abhiandroid.com/ui/videoview

Literacy2 (Sishir)

    This java class is for the "hard" level of the Literacy multiple-choice test. The layout of this page is defined by literacy2.xml. We
    picked that layout of the question displaying in the top and then four multiple choice buttons below. This layout was picked due to its
    simplicicity. Since kids are targeted by the application, it has to be easy to read and straight-forward. The four buttons are defined
    by the ids "choice1/2/3/4". The ID of the text box at the top is "question" and that is where question text (from firebase) displays inside.

    As we get into the code, the top of the page has all of the different modules that have been imported. Two of importance are the text-to-speech
    module and the four that add firebase functionality. From there, we defined the TextView mQuestion field and the four buttons from the layout
    page. mScore and mQuestionNumber are set at 0 to start the test. As the code runs, that int will iterate to the next one and so on. mQuestionlength
    is defined at 20 because each test bank (from Firebase) has 20 questions. In the updateQuestion function, the direct firebase addresses are
    defined for each part of the question; for example, question/choice1,2,3,4/answer.

    As the application is running, it will use the JSON file from the app directly and these firebase addresses to bring and display the questions.
    If the user gets a question right, there is a pop-up that comes up. There, the user will be asked if they want to advance to the next
    question or hear the answer (via the TTS module) AND advance to the next question. In the background, the application is also keeping track of the user's score.
    If the user achieves a score of, at least, 15 out of 20, it will redirect to the LiteracyVideo pages, where the user will see
    a "good job" message and then play a quick kids video.

    To get to the hard literacy test page, the user has to press the "play" action when the app starts up, and then click the ABC button. From there
    you will see two different buttons on the button half of the page labeled Level 1 and Level 2. This page is called LiteracyHome. If you click on
    the "Level 2" button, it will lead to the Literacy.xml page, which is defined by the Literacy.java class.
    The hard literacy test consists of harder ABC questions, such as filling in the missing letter of simple three and four letter words.
    For example, the first question is "D _ G." and the blank has to be filled in with "O" from the answer choices. There are roughly 10-15
    questions that are simple three letter words and 5-10 questions that are simple four letter words; for a total of 20 questions. The questions
    were created by Sishir. Again, did not get them from an online database or anything.

    More information about the Firebase function is in the Firebase section of this document.

    Used this tutorial/walkthrough to base code off of: https://youtu.be/-4bZ_rfvBTk

LiteracyHome (Casey)

    This is a main page for literacy where user can choose to view flashcards or take level 1 or 2 tests. The layout of this page
    is defined by the literacyhome.xml page in the layout folder.

Literacy2Video (SoJung)

    The page has video reward for literacy level 2 test. Videoview is first declared from the layout. The media controller is created
    so that when the user touches the video, the controller pops up from the bottom of the screen. Then the URI for the video is set.
    The video starts upon arriving on the page. After finishing the video, little message comes up saying "Great work." If any error occurs
    during playing the video, the error message will come up. This page's layout is defined by the literacy2video.xml page in the layout folder.
    Used this tutorial to base code off of: http://abhiandroid.com/ui/videoview

MathBeginnerVideo (SoJung)

    The page has video reward for math level 1 test. Videoview is first declared from the layout. The media controller is created
    so that when the user touches the video, the controller pops up from the bottom of the screen. Then the URI for the video is set.
    The video starts upon arriving on the page. After finishing the video, little message comes up saying "Great work." If any error occurs
    during playing the video, the error message will come up. This page's layout is defined by the mathbeginnervideo.xml page in the layout folder.
    Used this tutorial to base code off of: http://abhiandroid.com/ui/videoview

MathHome

    This is where the user can choose which level of math test to take.This page's layout is defined by the mathhome.xml page.

MathInterVideo (SoJung)

    The page has video reward for math level 2 test. Videoview is first declared from the layout. The media controller is created
    so that when the user touches the video, the controller pops up from the bottom of the screen. Then the URI for the video is set.
    The video starts upon arriving on the page. After finishing the video, little message comes up saying "Great work." If any error occurs
    during playing the video, the error message will come up. This page's layout is defined by the mathintervideo.xml page in the layout folder.
    Used this tutorial to base code off of: http://abhiandroid.com/ui/videoview
