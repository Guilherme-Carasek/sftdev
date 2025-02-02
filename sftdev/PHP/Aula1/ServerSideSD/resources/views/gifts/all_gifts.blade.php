@extends('layouts.main_layout')
@section('content')

    @if (session('message'))
        <div class="alert alert-success">
            {{ session('message') }}
        </div>
    @endif

<div class="row">
    <div class="col-12 col-lg-7">
        <h1>Prendas</h1>

        <table class="table">
            <thead>
                <tr>

                    <th scope="col">Prenda</th>

                    <th scope="col">Presenteado</th>

                    <th scope="col"></th>

                </tr>
            </thead>
            <tbody>
                @foreach($gifts as $gift)
                    <tr>
                        <th scope="row"> {{ $gift->name }} </th>

                        <td> {{ $gift->userName }} </td>

                        <td><a href=" {{route('gift.show', $gift->id)}} "> <button type="button" class="btn btn-info">Ver</button></a>
                            <a href=" {{route('gifts.add', $gift->id)}} "><button class="btn btn-warning">Editar</button></a>
                            <a href=" {{route('gift.delete', $gift->id)}} "> <button type="button" class="btn btn-danger">Deletar</button> </a></td>
                    </tr>
                @endforeach
                <tr>
                    <td><a href="{{ route('gifts.add', 0) }}"><button class="btn btn-success">Adicionar prenda</button></a></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

@endsection
