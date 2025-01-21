<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class homeController extends Controller
{
    public function index () {
        $myVar = 'Hello world!';

        $contactInfo = $this->getContactInfo();
        /* dd($contactInfo); */

        return view('home', compact('myVar', 'contactInfo'));
    }

    private function getContactInfo (){
        $contactInfo = [
            'name' => 'Guilherme',
            'email' => 'gmc@mail.com'
        ];

        return $contactInfo;
    }
}
