import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-categoriaposible.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaListacategoriasposibles extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-list-box id="lista_categoria_posible"></vaadin-list-box>
<vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="width: 100%; height: 100%;">
 <vaadin-button id="boton_aniadir_categoria_posible">
   Añadir 
 </vaadin-button>
 <vaadin-button id="boton_cancelar">
  Cancelar
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listacategoriasposibles';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacategoriasposibles.is, VistaListacategoriasposibles);
