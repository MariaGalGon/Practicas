import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaOferta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" id="vaadinHorizontalLayout" theme="spacing-xl" id="vaadinHorizontalLayout" theme="spacing-xl">
 <label id="nombre_oferta" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);"></label>
 <p id="detalles_oferta">s</p>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="justify-content: flex-end; flex-grow: 1;">
  <vaadin-button id="boton_editar">
   Editar
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-oferta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaOferta.is, VistaOferta);
