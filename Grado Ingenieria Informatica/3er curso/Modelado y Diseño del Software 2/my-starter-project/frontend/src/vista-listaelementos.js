import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import './vista-elemento.js';

class VistaListaelementos extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-list-box id="vaadinListBox" style="align-self: stretch; width: 100%; flex-grow: 1;"></vaadin-list-box>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1">
  <vaadin-button id="boton_eliminar">
    Eliminar 
  </vaadin-button>
 
  <vaadin-button id="boton_cancelar">
    Cancelar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaelementos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaelementos.is, VistaListaelementos);
