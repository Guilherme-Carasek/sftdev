<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class taskController extends Controller
{
    public function showAllTasks(){
        $tasks = $this->getTasks();
        $availableTasks = $this->getAvailableTasks();
        return view('tasks.all_tasks', compact('tasks', 'availableTasks'));
    }


    private function getTasks(){
        $tasks = [
        ['name' => 'Rita', 'task' => 'Estudar laravel'],
        ['name' => 'João', 'task' => 'Estudar Mysql']
        ];
        return $tasks;
    }

    private function getAvailableTasks() {
        $availableTasks = [ 'sql', 'js', 'java', 'POO'];
        return $availableTasks;
    }
}
