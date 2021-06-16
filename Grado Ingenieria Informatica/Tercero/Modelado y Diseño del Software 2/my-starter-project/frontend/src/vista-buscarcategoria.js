import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class VistaBuscarcategoria extends PolymerElement {

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
<vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="width: 100%; justify-content: center;" dir="cuadro_barra_buscar_categoria">
 <vaadin-horizontal-layout theme="spacing" style="align-self: center; width: 80%; justify-content: center; flex-grow: 0; flex-shrink: 0;">
  <img id="logo">
  <vaadin-text-field placeholder="Categoría" style="align-self: center; flex-grow: 1;" id="barra_buscar_categoria"></vaadin-text-field>
  <vaadin-button style="align-self: center;" id="vaadinButton" dir="boton_buscar_categoria">
    Buscar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-buscarcategoria';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaBuscarcategoria.is, VistaBuscarcategoria);
