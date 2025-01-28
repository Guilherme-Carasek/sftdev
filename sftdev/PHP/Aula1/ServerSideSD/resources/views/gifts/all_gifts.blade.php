@extends('layouts.main_layout')
@section('content')
<h1>Prendas</h1>

<table class="table">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Prenda</th>
        <th scope="col">Valor esperado</th>
        <th scope="col">Receberá</th>
        <th scope="col">Valor gasto</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
@foreach($gifts as $gift)
        <tr>
            <th scope="row"> {{ $gift->id }} </th>
            <td> {{ $gift->name }} </td>
            <td> {{ $gift->expectedValue }} </td>
            <td> {{ $gift->userName }} </td>
            <td> {{ $gift->spentValue }} </td>
            <td><a href=" {{route('gift.show',$gift->id)}} "> <button style="margin-right: 12px" type="button" class="btn btn-info">Ver</button></a>
                <a href=""> <button type="button" class="btn btn-danger">Deletar</button> </a></td>
        </tr>
@endforeach

    </tbody>
  </table>

@endsection
