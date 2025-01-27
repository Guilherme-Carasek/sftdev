<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class taskController extends Controller
{
    public function showAllTasks(){
        $tasks = $this->getTasks();
        return view('tasks.all_tasks', compact('tasks'));
    }


    private function getTasks(){
        $tasks = DB::table('tasks')->get();
        return $tasks;
    }
}
