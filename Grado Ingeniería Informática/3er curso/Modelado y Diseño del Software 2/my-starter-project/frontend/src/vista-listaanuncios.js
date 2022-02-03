import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-anuncio.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class VistaListaanuncios extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="lista_anuncios" theme="spacing-s">
 <vaadin-list-box id="vaadinListBox" style="flex-grow: 0;" dir="boton_aniadir_trabajador">

 </vaadin-list-box>
 <vaadin-button id="boton_aniadir_anuncio" style="align-self: center;">
   Añadir 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaanuncios';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaanuncios.is, VistaListaanuncios);
