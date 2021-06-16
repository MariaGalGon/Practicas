import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaTrabajador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        		
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" id="vaadinHorizontalLayout" theme="spacing-xl">
 <label id="id_trabajador" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);"></label>
 <p id="estado_trabajdor"></p>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="flex-grow: 1; justify-content: flex-end;">
  <vaadin-button id="vaadinButton" dir="boton_editar_trabajador">
    Editar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-trabajador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaTrabajador.is, VistaTrabajador);
