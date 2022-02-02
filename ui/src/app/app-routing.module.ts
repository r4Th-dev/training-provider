import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundRoutingModule} from "./not-found/not-found-routing.module";

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    NotFoundRoutingModule,
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
