import firebase from 'firebase/app'
import 'firebase/auth'

  var firebaseConfig = {
    apiKey: "AIzaSyBMJ9ARoRCNFRZATh6-6hPEHKz_NqUE_TI",
    authDomain: "reactjs-63f0d.firebaseapp.com",
    projectId: "reactjs-63f0d",
    storageBucket: "reactjs-63f0d.appspot.com",
    messagingSenderId: "513157809899",
    appId: "1:513157809899:web:35f869fe6629307841a0ae",
    measurementId: "G-FB3CFY74J9"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  firebase.analytics();

export default firebase;