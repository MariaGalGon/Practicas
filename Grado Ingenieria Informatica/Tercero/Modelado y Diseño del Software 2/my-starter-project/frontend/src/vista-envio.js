import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaEnvio extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s); padding-top: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs);">
 <label id="id_envio" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);"></label>
 <p id="estado" style="flex-grow: 1;"></p>
 <vaadin-button id="boton_ver_mas">
   Ver Más 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-envio';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEnvio.is, VistaEnvio);
