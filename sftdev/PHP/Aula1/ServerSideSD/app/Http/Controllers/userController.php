<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class userController extends Controller
{
    public function showAllUsers() {
        $cesaeInfo = $this->getCesaeInfo();
        $allContacts = $this->getAllContacts();
        $allUsers = $this->getAllUsers();

        return view('users.all_users', compact('cesaeInfo', 'allContacts', 'allUsers'));
    }

    public function addUsers($id) {
        if( $id != 0 ){
            $user = DB::table('users')
            ->where('users.id', $id)
            ->select('users.id', 'users.name', 'users.email', 'users.adress')
            ->first();
        }
        else $user = (object) array('id' => 0);

        return view('users.add_users', compact('user'));
    }

    private function getCesaeInfo (){
        $cesaeInfo = [
            'name' => 'CESAE Digital',
            'adress' => 'R. Ciríaco Cardoso 186, BoaVista, Porto',
            'email' => 'cesaedigital@cesaedigital.pt'
        ];
        return $cesaeInfo;
    }

    protected function getAllContacts () {
        $contacts = [
            ['id' => '1', 'name' => 'Sara', 'number' => '911344588'],
            ['id' => '2', 'name' => 'Bruno', 'number' => '911344588'],
            ['id' => '3', 'name' => 'Márcia', 'number' => '911344588']
        ];
        return $contacts;
    }

    protected function getAllUsers () {
        $allUsers = DB::table('users')->get();
        return $allUsers;
    }

    public function showUser($id){
        $user = DB::table('users')
        ->where ('users.id', $id)
        ->select('users.id', 'users.name', 'users.email', 'users.adress')
        ->first();

        $tasks = DB::table('tasks')
        ->where( 'tasks.user_id', $id )
        ->select( 'tasks.id', 'tasks.name', 'tasks.status' )
        ->get();

        $gifts = DB::table( 'gifts' )
        ->where( 'gifts.user_id', $id )
        ->select( 'gifts.id', 'gifts.name' )
        ->get();

        return view('users.user_info', compact('user', 'tasks', 'gifts'));
    }

    public function deleteUser($id){
        DB::table('tasks')
        ->where('user_id', $id)
        ->delete();

        DB::table('gifts')
        ->where('user_id', $id)
        ->delete();

        DB::table('users')
        ->where('id', $id)
        ->delete();

        return redirect()->route('users.show')->with('message', 'Utilizador removido com sucesso');
    }

    public function createUser(Request $request){

        $request->validate([
            'name' => 'required | String | min:3',
            'email' => 'required | email | unique:users',
            'adress' => 'nullable'
        ]);

        if ( !isset($request->id) ) {
            $request->validate([
                'password' => 'required | min:6'
            ]);

            User::insert([
                'name' => $request->name,
                'email' => $request->email,
                'password' => Hash::make($request->password),
                'adress' => $request->adress
            ]);

            return redirect()->route('users.show')->with('message', 'Utilizador adicionado com sucesso');
        }
        else {
            DB::table('users')
            ->where('id', $request->id)
            ->update([
                'name' => $request->name,
                'email' => $request->email,
                'adress' => $request->adress
            ]);

            return redirect()->route('users.show')->with('message', 'Utilizador atualizado com sucesso');
        }
    }
}
